import { useState } from 'react';
import usuarioService from '../services/Usuario'; // importe o serviço correto
import styles from '../styles';

export default function UsuarioForm() {
  const [form, setForm] = useState({
    nome: '',
    matricula: '',
    acesso_loc: '',
    estado: ''
  });

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();

    usuarioService.criarUsuario(form)
      .then(() => {
        alert('Usuário cadastrado com sucesso!');
        setForm({ nome: '', matricula: '', acesso_loc: '', estado: '' }); // limpa o form após cadastro
      })
      .catch(() => {
        alert('Erro ao cadastrar usuário');
      });
  };

  return (
    <div style={styles.formContainer}>
      <h2 style={styles.formTitle}>Cadastro de Usuário</h2>
      <form onSubmit={handleSubmit} style={styles.form}>
        <input
          name="nome"
          placeholder="Nome"
          value={form.nome}
          onChange={handleChange}
          style={styles.input}
        />
        <input
          name="matricula"
          placeholder="Matrícula"
          value={form.matricula}
          onChange={handleChange}
          style={styles.input}
        />
        <input
          name="acesso_loc"
          placeholder="Local de Acesso"
          value={form.acesso_loc}
          onChange={handleChange}
          style={styles.input}
        />
        <input
          name="estado"
          placeholder="Estado"
          value={form.estado}
          onChange={handleChange}
          style={styles.input}
        />
        <button type="submit" style={styles.submitButton}>Cadastrar</button>
      </form>
    </div>
  );
}
