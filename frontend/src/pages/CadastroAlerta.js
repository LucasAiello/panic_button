import React, { useEffect, useState } from 'react';
import alertaService from '../services/Alerta';
import styles from '../styles';

export default function AlertaForm() {
  const [form, setForm] = useState({
    titulo: '',
    descricao: '',
    prioridade: ''
  });

  const [latitude, setLatitude] = useState('');
  const [longitude, setLongitude] = useState('');
  const [permissaoLocalizacao, setPermissaoLocalizacao] = useState(false);
  const [perguntouLocalizacao, setPerguntouLocalizacao] = useState(false);

  useEffect(() => {
    if (!perguntouLocalizacao) {
      const permitir = window.confirm('Podemos acessar sua localização para cadastrar o alerta?');
      setPerguntouLocalizacao(true);
      setPermissaoLocalizacao(permitir);
    }
  }, [perguntouLocalizacao]);

  useEffect(() => {
    if (permissaoLocalizacao) {
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
    }
  }, [permissaoLocalizacao]);

  const handleChange = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();

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

        {!permissaoLocalizacao && perguntouLocalizacao && (
          <p style={{ color: 'red' }}>Localização não autorizada. O alerta será criado sem ela.</p>
        )}

        <button type="submit" style={styles.submitButton}>Criar Alerta</button>
      </form>
    </div>
  );
}
