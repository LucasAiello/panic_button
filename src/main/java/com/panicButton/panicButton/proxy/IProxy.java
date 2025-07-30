package com.panicButton.panicButton.proxy;

import com.panicButton.panicButton.domain.Administrador;
import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.dto.AlertaDTO;
import com.panicButton.panicButton.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface IProxy {
    Usuario createUsuario(UsuarioDTO usuarioDTO);
    Administrador createAdministrador(Usuario usuario);
    Optional<Usuario> getUsuario(String matricula);
    Usuario updateUsuario(UsuarioDTO usuarioDTO);
    Optional<Usuario> removeUsuario(String matricula);

    List<Alerta> getAlerta(Usuario usuario);
    Iterable<Alerta> getAlertasAtivos();
    Optional<Alerta> removeAlerta(Long id);
    Alerta createAlerta(AlertaDTO alertaDTO) throws Exception;
    Alerta updateAlerta(AlertaDTO alertaDTO);
}
