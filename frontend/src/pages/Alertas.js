import { useEffect, useState } from 'react';
import styles from '../styles';

const Alertas = () => {
  const [alertas, setAlertas] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/alertas')
      .then((res) => res.json())
      .then((data) => setAlertas(data))
      .catch((err) => console.error('Erro ao buscar alertas:', err));
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
              <p><strong>Usuário:</strong> {alerta.usuario?.nome || 'Desconhecido'}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Alertas;
