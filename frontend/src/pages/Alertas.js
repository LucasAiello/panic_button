import { useEffect, useState } from 'react';
import alertaService from '../services/Alerta';
import usuarioService from '../services/Usuario';
import styles from '../styles';

const Alertas = () => {
  const [alertas, setAlertas] = useState([]);

  useEffect(() => {
    const buscarAlertasInativosComUsuario = async () => {
      try {
        const todosAlertas = await alertaService.buscarAlertas();
        const inativos = todosAlertas.filter(alerta => alerta.ativo === 0);

        // Enriquecer cada alerta com o nome do usuário
        const alertasComNome = await Promise.all(
          inativos.map(async alerta => {
            try {
              const usuario = await usuarioService.buscarUsuario(alerta.usuarioId);
              return { ...alerta, nomeUsuario: usuario.nome };
            } catch (e) {
              console.warn(`Erro ao buscar usuário ${alerta.usuarioId}:`, e);
              return { ...alerta, nomeUsuario: 'Desconhecido' };
            }
          })
        );

        setAlertas(alertasComNome);
      } catch (err) {
        console.error('Erro ao buscar alertas:', err);
      }
    };

    buscarAlertasInativosComUsuario();
  }, []);

  return (
    <div style={styles.alertasContainer}>
      <h2 style={styles.alertasTitle}>Lista de Alertas</h2>
      {alertas.length === 0 ? (
        <p style={styles.semAlerta}>Nenhum alerta encontrado.</p>
      ) : (
        <ul style={styles.alertasList}>
          {alertas.map((alerta) => (
            <li key={alerta.id} style={styles.alertaCard}>
              <p><strong>Motivo:</strong> {alerta.motivo}</p>
              <p><strong>Usuário:</strong> {alerta.nomeUsuario}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Alertas;
