import axios from 'axios';

// Instância axios configurada com baseURL da sua API
const api = axios.create({
  baseURL: 'http://localhost:8080/api/panico',
});

class AlertaService {
  criarAlerta(alertaDTO) {
    return api.post('/create-alerta', alertaDTO)
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao criar alerta:', error.response?.data || error.message);
        throw error;
      });
  }

  buscarAlerta(id) {
    return api.get('/get-alerta', { params: { id } })
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao buscar alerta:', error.response?.data || error.message);
        throw error;
      });
  }

  atualizarAlerta(alertaDTO) {
    return api.put('/update-alerta', alertaDTO)
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao atualizar alerta:', error.response?.data || error.message);
        throw error;
      });
  }

  deletarAlerta(id) {
    return api.delete('/delete-alerta', { params: { id } })
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao deletar alerta:', error.response?.data || error.message);
        throw error;
      });
  }
}

const instance = new AlertaService();
export default instance;
