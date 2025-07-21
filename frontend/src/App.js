import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import CadastroAlerta from './pages/CadastroAlerta';
import Alertas from './pages/Alertas';
import styles from './styles';

function App() {
  return (
    <Router>
      <header style={styles.header}>
        <h1 style={styles.title}>Botão de Pânico</h1>
        <nav style={styles.nav}>
          <Link to="/" style={styles.link}>Início</Link>
          <Link to="/cadastro" style={styles.link}>Cadastrar Alerta</Link>
          <Link to="/alertas" style={styles.link}>Alertas</Link>
        </nav>
      </header>

      <main style={styles.main}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/cadastro" element={<CadastroAlerta />} />
          <Route path="/alertas" element={<Alertas />} />
        </Routes>
      </main>
    </Router>
  );
}

export default App;
