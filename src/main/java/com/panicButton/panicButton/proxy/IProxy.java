package com.panicButton.panicButton.proxy;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;

import java.util.Optional;

public interface IProxy {
    Usuario createUsuario(Usuario usuario);
    Optional<Alerta> getAlerta(Long id);
    void removeAlerta(Alerta alerta);
    Alerta createAlerta(Alerta alerta);
    Alerta updateAlerta(Long id, Alerta alerta);
    Optional<Usuario> getUsuario(String matricula);
    Usuario updateUsuario(String matricula, Usuario usuario);
}
