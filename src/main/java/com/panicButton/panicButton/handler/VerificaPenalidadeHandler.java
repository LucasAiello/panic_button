package com.panicButton.panicButton.handler;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.repository.UsuarioRepository;
import com.panicButton.panicButton.state.Ativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificaPenalidadeHandler extends AlertaHandler {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    protected void processa(Alerta alerta) throws Exception {
        Optional<Usuario> opt = usuarioRepository.findById(alerta.getUsuario().getMatricula());
        if (opt.isPresent() && !(opt.get().getEstado() instanceof Ativo)) {
            throw new Exception("Penalidade aplicada");
        }
        System.out.println("Penalidade validada.");
    }

}
