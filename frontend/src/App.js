import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import Alertas from './pages/Alertas';
import CadastroAlerta from './pages/CadastroAlerta';
import styles from './styles';
import MapaAlertas from './pages/MapaAlerta';

function App() {
  return (
    <Router>
      <header style={styles.header}>
        <h1 style={styles.title}>Botão de Pânico</h1>
        <nav style={styles.nav}>
          <Link to="/" style={styles.link}>Início</Link>
          <Link to="/mapa" style={styles.link}>Alertas</Link>
          <Link to="/alertas" style={styles.link}>Ultimos alertas</Link>
        </nav>
      </header>

      <main style={styles.main}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/mapa" element={<MapaAlertas />} />
          <Route path="/alertas" element={<Alertas />} />
            <Route path="/cadastroAlerta" element={<CadastroAlerta />} />
        </Routes>
      </main>
    </Router>
  );
}

export default App;
