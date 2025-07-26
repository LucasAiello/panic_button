import React, { useState } from 'react';
import alertaService from '../services/Alerta';
import styles from '../styles';

export default function AlertaForm() {
  const [form, setForm] = useState({
    titulo: '',
    descricao: '',
    longitude: '',
    latitude: '',
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
        setForm({ titulo: '', descricao: '', longitude: '', latitude: '', prioridade: '' });
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
          name="longitude"
          placeholder="Longitude"
          value={form.longitude}
          onChange={handleChange}
          style={styles.input}
        />
        <input
          name="latitude"
          placeholder="Latitude"
          value={form.latitude}
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
