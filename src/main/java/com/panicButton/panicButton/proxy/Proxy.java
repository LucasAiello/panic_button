package com.panicButton.panicButton.proxy;

import com.panicButton.panicButton.domain.Administrador;
import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.dto.AlertaDTO;
import com.panicButton.panicButton.dto.UsuarioDTO;
import com.panicButton.panicButton.service.Sistema;

import java.util.Optional;

public class Proxy implements IProxy {
    private Sistema sistema = Sistema.getInstance();

    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        return sistema.createUsuario(usuarioDTO);
    }
    public Administrador createAdministrador(Usuario usuario) {
        return sistema.createAdministrador(usuario);
    }
    public Optional<Usuario> getUsuario(String matricula) {
        return sistema.getUsuario(matricula);
    }
    public Usuario updateUsuario(UsuarioDTO usuarioDTO) {
        return sistema.updateUsuario(usuarioDTO);
    }
    public Optional<Usuario> removeUsuario(String matricula) {
        return sistema.removeUsuario(matricula);
    }

    public Alerta createAlerta(AlertaDTO alertaDTO) {
        return sistema.createAlerta(alertaDTO);
    }
    public Optional<Alerta> getAlerta(Long id) {
        return sistema.getAlerta(id);
    }
    public Alerta updateAlerta(AlertaDTO alertaDTO) {
        return sistema.updateAlerta(alertaDTO);
    }
    public Optional<Alerta> removeAlerta(Long id) {
        return sistema.removeAlerta(id);
    }
}
