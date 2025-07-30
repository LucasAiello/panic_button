import { useEffect, useState } from 'react';
import alertaService from '../services/Alerta'
import styles from '../styles';

 const Alertas = () => {
  const [alertas, setAlertas] = useState([]);
  const [ids] = useState([1, 2, 3]); 

  useEffect(() => {
    const buscarAlertasInativos = async () => {
      try {
        const resultados = await Promise.all(
          ids.map(ativo => alertaService.buscarAlerta(ativo))
        );
        const inativos = resultados.filter(alerta => alerta.ativo === 0);
        setAlertas(inativos);
        } catch (err) {
        console.error('Erro ao buscar alertas:', err);
      }
    };

    buscarAlertasInativos();
  }, [ids]);

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
              <p><strong>Usuário:</strong> {alerta.usuario?.nome || 'Desconhecido'}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Alertas;
