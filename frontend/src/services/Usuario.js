import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api/panico',
});

class UsuarioService {
  criarUsuario(usuarioDTO) {
    return api.post('/create-usuario', usuarioDTO)
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao criar usuário:', error.response?.data || error.message);
        throw error;
      });
  }

  buscarUsuario(matricula) {
    return api.get('/get-usuario', { params: { matricula } })
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao buscar usuário:', error.response?.data || error.message);
        throw error;
      });
  }

  atualizarUsuario(usuarioDTO) {
    return api.put('/update-usuario', usuarioDTO)
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao atualizar usuário:', error.response?.data || error.message);
        throw error;
      });
  }

  deletarUsuario(matricula) {
    return api.delete('/delete-usuario', { params: { matricula } })
      .then(res => res.data)
      .catch(error => {
        console.error('Erro ao deletar usuário:', error.response?.data || error.message);
        throw error;
      });
  }
}

const instance = new UsuarioService();
export default instance;
