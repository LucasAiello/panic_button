import React, { useEffect, useState } from 'react';
import alertaService from '../services/Alerta';
import styles from '../styles';

import useUsuarioId from '../hooks/useUsuarioId';
 // Vai pedir só na primeira vez

export default function AlertaForm() {
  const [form, setForm] = useState({
    titulo: '',
    motivo: '',
    prioridade: ''
  });

  const [latitude, setLatitude] = useState('');
  const [longitude, setLongitude] = useState('');
  const usuarioId = useUsuarioId();
 
  // localização
  useEffect(() => {
    const permitir = window.confirm('Podemos acessar sua localização para cadastrar o alerta?');
    if (permitir && navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        pos => {
          setLatitude(pos.coords.latitude);
          setLongitude(pos.coords.longitude);
        },
        err => {
          console.log("Erro ao obter localização:", err.message);
        },
        {
          enableHighAccuracy: true, // Solicita a maior precisão possível
          timeout: 10000,           // Tempo máximo (em ms) para tentar obter a localização
          maximumAge: 0             // Impede o uso de uma posição em cache
        }
      );

    }
  }, []);

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();

    const alerta = {
      ...form,
      latitude,
      longitude,
      usuarioId // ← Aqui vai o ID da máquina
    };

    alertaService.criarAlerta(alerta)
      .then(() => {
        alert('Alerta criado com sucesso!');
        setForm({
          titulo: '',
          motivo: '',
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
