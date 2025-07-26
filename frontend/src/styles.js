// src/styles.js

const styles = {
 header: {
  backgroundColor: '#ff7f27',
  padding: '20px',
  color: '#fff',
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
},

title: {
  margin: '0',
  fontSize: '28px',
  fontWeight: 'bold',
  textAlign: 'center',
},
  nav: {
    marginTop: '10px',
  },
  link: {
    margin: '0 10px',
    color: '#fff',
    textDecoration: 'none',
    fontWeight: 'bold',
    fontSize: '16px',
  },
  main: {
    padding: '40px',
    backgroundColor: '#fff8f0',
    minHeight: 'calc(100vh - 120px)',
  },
  botaoContainer: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '60vh',
  },
  botaoPanico: {
  backgroundColor: '#f86e11ff',
    color: '#fff',
    border: 'none',
    padding: '20px 40px',
    height: '300px',
    width: '300px',
    fontSize: '24px',
    borderRadius: '300px',
    cursor: 'pointer',
    boxShadow: '0 4px 8px rgba(0,0,0,0.2)',
    transition: 'transform 0.2s',
  },
  formContainer: {
  maxWidth: '400px',
  margin: '0 auto',
  backgroundColor: '#fff',
  padding: '30px',
  borderRadius: '10px',
  boxShadow: '0 4px 12px rgba(0,0,0,0.1)',
  marginTop: '40px',
},

formTitle: {
  textAlign: 'center',
  fontSize: '24px',
  marginBottom: '20px',
  color: '#ff7f27',
},

form: {
  display: 'flex',
  flexDirection: 'column',
},

input: {
  padding: '12px',
  marginBottom: '15px',
  border: '1px solid #ccc',
  borderRadius: '8px',
  fontSize: '16px',
},

submitButton: {
  backgroundColor: '#ff7f27',
  color: '#fff',
  padding: '12px',
  border: 'none',
  borderRadius: '8px',
  fontSize: '18px',
  cursor: 'pointer',
  transition: 'background-color 0.3s ease',
},

submitButtonHover: {
  backgroundColor: '#e66410',
},
alertasContainer: {
  maxWidth: '800px',
  margin: '40px auto',
  padding: '20px',
  backgroundColor: '#fff8f0',
  borderRadius: '10px',
  boxShadow: '0 4px 12px rgba(0,0,0,0.1)',
},

alertasTitle: {
  textAlign: 'center',
  fontSize: '26px',
  color: '#ff7f27',
  marginBottom: '20px',
},

semAlerta: {
  textAlign: 'center',
  fontStyle: 'italic',
  color: '#888',
},

alertasList: {
  listStyle: 'none',
  padding: '0',
},

alertaCard: {
  backgroundColor: '#fff',
  border: '1px solid #ffd6c2',
  borderRadius: '8px',
  padding: '15px',
  marginBottom: '15px',
  boxShadow: '0 2px 5px rgba(0,0,0,0.05)',
},

};

export default styles;
