import api from '../services/Usuario';
import styles from '../styles';

export default function BotaoPanico() {
  const acionarPanico = async () => {
    try {
      const response = await api.get('/acionar');
      alert(response.data);
    } catch (error) {
      alert('Erro ao acionar o botão de pânico.');
    }
  };

  return (
    <div style={styles.botaoContainer}>
      <button onClick={acionarPanico} style={styles.botaoPanico}>
        ACIONAR PÂNICO
      </button>
    </div>
  );
}
