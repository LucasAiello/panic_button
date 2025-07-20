package com.panicButton.panicButton.proxy;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.service.Sistema;

public class Proxy implements IProxy {
    private Sistema sistema = Sistema.getInstance();

    public Usuario createUsuario(Usuario usuario) {
        return sistema.createUsuario(usuario);
    }

    public Alerta getAlerta(int id) {
        return sistema.getAlerta(id);
    }

    public void removeAlerta(int id) {
        sistema.removeAlerta(id);
    }

    public Alerta createAlerta(Alerta alerta) {
        return sistema.createAlerta(alerta);
    }

    public Alerta updateAlerta(int id, Alerta alerta) {
        return sistema.updateAlerta(id, alerta);
    }

    public Usuario getUsuario(String matricula) {
        return sistema.getUsuario(matricula);
    }

    public Usuario updateUsuario(String matricula, Usuario usuario) {
        return sistema.updateUsuario(matricula, usuario);
    }
}