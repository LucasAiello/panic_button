const styles = {
  // Cores atualizadas para um tema mais moderno e acessível
  colors: {
    primary: '#FF6B35', // Laranja mais vibrante
    secondary: '#004E89', // Azul complementar
    background: '#F8F9FA', // Fundo mais suave
    card: '#FFFFFF',
    text: '#333333',
    textLight: '#6C757D',
    danger: '#DC3545',
    success: '#28A745'
  },

  // Estilos globais atualizados
  global: {
    fontFamily: "'Segoe UI', 'Roboto', sans-serif",
    borderRadius: '12px',
    boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
    transition: 'all 0.3s ease'
  },

  // Header modernizado
  header: {
    backgroundColor: '#FF6B35',
    padding: '20px 0',
    color: '#FFFFFF',
    boxShadow: '0 2px 10px rgba(0, 0, 0, 0.1)',
    position: 'sticky',
    top: 0,
    zIndex: 100
  },

  title: {
    margin: '0',
    fontSize: '2rem',
    fontWeight: 700,
    textAlign: 'center',
    letterSpacing: '0.5px'
  },

  nav: {
    marginTop: '15px',
    display: 'flex',
    justifyContent: 'center',
    gap: '20px'
  },

  link: {
    color: '#FFFFFF',
    textDecoration: 'none',
    fontWeight: 600,
    fontSize: '1rem',
    padding: '8px 16px',
    borderRadius: '8px',
    transition: 'background-color 0.3s',
    '&:hover': {
      backgroundColor: 'rgba(255, 255, 255, 0.2)'
    }
  },

  // Container principal
  main: {
    padding: '40px 20px',
    backgroundColor: '#F8F9FA',
    minHeight: 'calc(100vh - 120px)'
  },

  // Botão de pânico modernizado
  botaoContainer: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    minHeight: '60vh'
  },

  botaoPanico: {
    backgroundColor: '#FF6B35',
    color: '#FFFFFF',
    border: 'none',
    padding: 0,
    height: '250px',
    width: '250px',
    fontSize: '1.5rem',
    borderRadius: '50%',
    cursor: 'pointer',
    boxShadow: '0 8px 15px rgba(255, 107, 53, 0.4)',
    transition: 'all 0.3s ease',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    textAlign: 'center',
    '&:hover': {
      transform: 'scale(1.05)',
      boxShadow: '0 10px 20px rgba(255, 107, 53, 0.5)'
    },
    '&:active': {
      transform: 'scale(0.98)'
    }
  },

  // Formulários modernizados
  formContainer: {
    maxWidth: '500px',
    margin: '0 auto',
    backgroundColor: '#FFFFFF',
    padding: '2rem',
    borderRadius: '12px',
    boxShadow: '0 4px 12px rgba(0, 0, 0, 0.08)'
  },

  formTitle: {
    textAlign: 'center',
    fontSize: '1.75rem',
    marginBottom: '1.5rem',
    color: '#FF6B35',
    fontWeight: 600
  },

  form: {
    display: 'flex',
    flexDirection: 'column',
    gap: '1rem'
  },

  input: {
    padding: '0.75rem 1rem',
    border: '1px solid #CED4DA',
    borderRadius: '8px',
    fontSize: '1rem',
    transition: 'border-color 0.3s',
    '&:focus': {
      outline: 'none',
      borderColor: '#FF6B35',
      boxShadow: '0 0 0 3px rgba(255, 107, 53, 0.2)'
    }
  },

  submitButton: {
    backgroundColor: '#FF6B35',
    color: '#FFFFFF',
    padding: '0.75rem',
    border: 'none',
    borderRadius: '8px',
    fontSize: '1.1rem',
    fontWeight: 600,
    cursor: 'pointer',
    transition: 'all 0.3s',
    marginTop: '0.5rem',
    '&:hover': {
      backgroundColor: '#E05A2B',
      transform: 'translateY(-2px)'
    }
  },

  // Lista de alertas modernizada
  alertasContainer: {
    maxWidth: '900px',
    margin: '2rem auto',
    padding: '2rem',
    backgroundColor: '#FFFFFF',
    borderRadius: '12px',
    boxShadow: '0 4px 12px rgba(0, 0, 0, 0.08)'
  },

  alertasTitle: {
    textAlign: 'center',
    fontSize: '1.75rem',
    color: '#FF6B35',
    marginBottom: '1.5rem',
    fontWeight: 600
  },

  semAlerta: {
    textAlign: 'center',
    color: '#6C757D',
    fontStyle: 'italic',
    padding: '1rem'
  },

  alertasList: {
    listStyle: 'none',
    padding: 0,
    display: 'grid',
    gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))',
    gap: '1rem'
  },

  alertaCard: {
    backgroundColor: '#FFFFFF',
    border: '1px solid #E9ECEF',
    borderRadius: '10px',
    padding: '1.25rem',
    boxShadow: '0 2px 8px rgba(0, 0, 0, 0.05)',
    transition: 'transform 0.3s, box-shadow 0.3s',
    '&:hover': {
      transform: 'translateY(-3px)',
      boxShadow: '0 6px 12px rgba(0, 0, 0, 0.1)',
      borderColor: '#FF6B35'
    }
  },

  // Mapa modernizado
  mapaContainer: {
    borderRadius: '12px',
    overflow: 'hidden',
    boxShadow: '0 6px 18px rgba(0, 0, 0, 0.1)',
    margin: '2rem 0',
    border: '1px solid #E9ECEF'
  }
};

export default styles;
