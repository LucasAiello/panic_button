import React, { useState } from 'react';
import alertaService from '../services/Alerta';
import styles from '../styles';

export default function AlertaForm() {
  const [form, setForm] = useState({
    titulo: '',
    descricao: '',
    localizacao: '',
    prioridade: ''
  });

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();

    alertaService.criarAlerta(form)
      .then(() => {
        alert('Alerta criado com sucesso!');
        setForm({ titulo: '', descricao: '', localizacao: '', prioridade: '' });
      })
      .catch(() => {
        alert('Erro ao criar alerta');
      });
  };

  return (
    <div style={styles.formContainer}>
      <h2 style={styles.formTitle}>Cadastro de Alerta</h2>
      <form onSubmit={handleSubmit} style={styles.form}>
        <input
          name="titulo"
          placeholder="Título"
          value={form.titulo}
          onChange={handleChange}
          style={styles.input}
        />
        <input
          name="descricao"
          placeholder="Descrição"
          value={form.descricao}
          onChange={handleChange}
          style={styles.input}
        />
        <input
          name="localizacao"
          placeholder="Localização"
          value={form.localizacao}
          onChange={handleChange}
          style={styles.input}
        />
        <input
          name="prioridade"
          placeholder="Prioridade"
          value={form.prioridade}
          onChange={handleChange}
          style={styles.input}
        />
        <button type="submit" style={styles.submitButton}>Criar Alerta</button>
      </form>
    </div>
  );
}
