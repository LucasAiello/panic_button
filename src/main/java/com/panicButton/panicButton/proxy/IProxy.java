package com.panicButton.panicButton.proxy;

import com.panicButton.panicButton.domain.Administrador;
import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.dto.UsuarioDTO;

import java.util.Optional;

public interface IProxy {
    Usuario createUsuario(UsuarioDTO usuarioDTO);
    Administrador createAdministrador(Usuario usuario);
    Optional<Usuario> getUsuario(String matricula);
    Usuario updateUsuario(String matricula, Usuario usuario);
    Optional<Usuario> removeUsuario(String matricula);

    Optional<Alerta> getAlerta(Long id);
    void removeAlerta(Alerta alerta);
    Alerta createAlerta(Alerta alerta);
    Alerta updateAlerta(Long id, Alerta alerta);
}
