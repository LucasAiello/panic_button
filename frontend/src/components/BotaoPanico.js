import { useNavigate } from 'react-router-dom';
import api from '../services/Usuario';
import styles from '../styles';

export default function BotaoPanico() {
  const navigate = useNavigate();

  const acionarPanico = async () => {
    try {
      navigate('/cadastroAlerta');
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
