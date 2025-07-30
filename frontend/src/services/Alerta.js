import axios from 'axios';

const api = axios.create({
  baseURL: 'api/panico',
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

  buscarAlertas() {
    return api.get('/get-alertas',)
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao buscar alerta:', error.response?.data || error.message);
        throw error;
      });
  }

  buscarAlertasPorAtivo() {
    return api.get('/get-alerta-ativos')
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
