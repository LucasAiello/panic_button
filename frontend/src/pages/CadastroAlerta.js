import React, { useEffect, useState } from 'react';
import alertaService from '../services/Alerta';
import styles from '../styles';

export default function AlertaForm() {
  // Estado só para os dados do formulário que o usuário preenche
  const [form, setForm] = useState({
    titulo: '',
    descricao: '',
    prioridade: ''
  });

  // Estados separados para latitude e longitude
  const [latitude, setLatitude] = useState('');
  const [longitude, setLongitude] = useState('');

  // Captura localização ao carregar o componente
  useEffect(() => {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        pos => {
          setLatitude(pos.coords.latitude);
          setLongitude(pos.coords.longitude);
        },
        err => {
          console.log("Erro ao obter localização:", err.message);
        }
      );
    } else {
      console.log("Geolocalização não é suportada neste navegador.");
    }
  }, []);

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();

    // Enviar form + latitude e longitude separados
    alertaService.criarAlerta({
      ...form,
      latitude,
      longitude
    })
      .then(() => {
        alert('Alerta criado com sucesso!');
        setForm({
          titulo: '',
          descricao: '',
          prioridade: ''
        });
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
          required
        />
        <input
          name="descricao"
          placeholder="Descrição"
          value={form.descricao}
          onChange={handleChange}
          style={styles.input}
          required
        />
        <select
          name="prioridade"
          value={form.prioridade}
          onChange={handleChange}
          style={styles.input}
          required
        >
          <option value="">Selecione a prioridade</option>
          <option value="Baixa">Baixa</option>
          <option value="Média">Média</option>
          <option value="Alta">Alta</option>
        </select>
        <button type="submit" style={styles.submitButton}>Criar Alerta</button>
      </form>
    </div>
  );
}
