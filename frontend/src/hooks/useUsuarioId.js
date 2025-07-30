import { useEffect, useState } from 'react';

export default function useUsuarioId() {
  const [usuarioId, setUsuarioId] = useState('');

  useEffect(() => {
    let id = localStorage.getItem('matricula');

    if (!id) {
      // Solicita ao usuário que digite um ID
      id = prompt('Digite sua matrícula ou identificador único:');

      // Se o usuário não digitar nada, repete o prompt
      while (!id || id.trim() === '') {
        id = prompt('⚠️ Você precisa informar um identificador válido:');
      }

      localStorage.setItem('usuarioId', id);
    }

    setUsuarioId(id);
  }, []);

  return usuarioId;
}
