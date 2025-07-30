import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { AuthProvider } from './contexts/AuthContext';
import PrivateRoute from './components/PrivateRoute';
import Login from './pages/Login';
import Home from './pages/Home';
import Alertas from './pages/Alertas';
import CadastroAlerta from './pages/CadastroAlerta';
import MapaAlertas from './pages/MapaAlerta';
import styles from './styles';

function App() {
  return (
    <AuthProvider>
      <Router>
        <header style={styles.header}>
          <h1 style={styles.title}>Botão de Pânico</h1>
          <nav style={styles.nav}>
            <a href="/" style={styles.link}>Início</a>
            <a href="/mapa" style={styles.link}>Alertas</a>
            <a href="/alertas" style={styles.link}>Últimos alertas</a>
          </nav>
        </header>

        <main style={styles.main}>
          <Routes>
            <Route path="/login" element={<Login />} />

            <Route path="/" element={
              <PrivateRoute>
                <Home />
              </PrivateRoute>
            } />
            <Route path="/mapa" element={
              <PrivateRoute>
                <MapaAlertas />
              </PrivateRoute>
            } />
            <Route path="/alertas" element={
              <PrivateRoute>
                <Alertas />
              </PrivateRoute>
            } />
            <Route path="/cadastroAlerta" element={
              <PrivateRoute>
                <CadastroAlerta />
              </PrivateRoute>
            } />
          </Routes>
        </main>
      </Router>
    </AuthProvider>
  );
}

export default App;
