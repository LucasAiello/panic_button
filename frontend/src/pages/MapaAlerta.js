import React, { useEffect, useRef, useState } from 'react';
import 'ol/ol.css';
import alertaService from '../services/Alerta'
import usuarioService from '../services/Usuario';
import { Map, View } from 'ol';
import { Tile as TileLayer, Vector as VectorLayer } from 'ol/layer';
import { OSM, Vector as VectorSource } from 'ol/source';
import { Point } from 'ol/geom';
import Feature from 'ol/Feature';
import { fromLonLat } from 'ol/proj';
import Style from 'ol/style/Style';
import Icon from 'ol/style/Icon';
import styles from '../styles';

export default function MapaAlertas() {
  const mapRef = useRef();
  const [vectorSource] = useState(new VectorSource());
  const [usuarioBloqueado, setUsuarioBloqueado] = useState(false);
  let alerta = false;

  useEffect(() => {
    const verificarEstadoUsuario = async () => {
      const matricula = localStorage.getItem('matricula');
      if (!matricula) return;

      try {
        const usuario = await usuarioService.buscarUsuario(matricula);
        if (usuario.estado === 'BLOQUEADO') {
          setUsuarioBloqueado(true);
        } else {
          setUsuarioBloqueado(false);
        }
      } catch (err) {
        console.error('Erro ao buscar usuário:', err);
      }
    };

    verificarEstadoUsuario();
  }, []);

  useEffect(() => {
    if (usuarioBloqueado) return;

    const map = new Map({
      target: mapRef.current,
      layers: [
        new TileLayer({ source: new OSM() }),
        new VectorLayer({ source: vectorSource })
      ],
      view: new View({
        center: fromLonLat([-35.9164, -7.2397]), 
        zoom: 18
      })
    });

    const fetchAlertas = async () => {
      try {
        const resultados = await alertaService.buscarAlertasPorAtivo();
        const ativos = resultados.filter(alerta => alerta.ativo === 1 && alerta.usuario?.estado !== 'BLOQUEADO');

        vectorSource.clear();

        if (ativos.length > 0) {
          ativos.forEach(alerta => {
            const coord = fromLonLat([alerta.longitude, alerta.latitude]);
            const feature = new Feature(new Point(coord));

            feature.setStyle(new Style({
              image: new Icon({
                anchor: [0.5, 1],
                src: 'https://cdn-icons-png.flaticon.com/512/1828/1828665.png',
                scale: 0.07
              })
            }));

            vectorSource.addFeature(feature);
          });

          if (!alerta) {
            alert('⚠️ ALERTA(S) ATIVO(S) DETECTADO(S)!');
            alerta = true;
          }
        } else {
          alerta = false;
        }
      } catch (error) {
        console.error('Erro ao buscar alertas:', error);
      }
    };

    fetchAlertas();
    const intervalId = setInterval(fetchAlertas, 10000);

    return () => clearInterval(intervalId);
  }, [usuarioBloqueado, vectorSource]);

  if (usuarioBloqueado) {
    return <p style={{ textAlign: 'center', color: 'red' }}>Acesso bloqueado. Você não pode visualizar o mapa.</p>;
  }

  return (
    <div style={styles.mapaContainer}>
      <div ref={mapRef} style={{ width: '100%', height: '500px' }} />
    </div>
  );
}
