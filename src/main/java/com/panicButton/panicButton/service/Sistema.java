package com.panicButton.panicButton.service;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;

import java.util.HashMap;
import java.util.Map;

public class Sistema {
    private static Sistema instance = null;

    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<Integer, Alerta> alertas = new HashMap<>();

    private Sistema() {}

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public Usuario createUsuario(Usuario usuario) {
        usuarios.put(usuario.getMatricula(), usuario);
        return usuario;
    }

    public Usuario getUsuario(String matricula) {
        return usuarios.get(matricula);
    }

    public Usuario updateUsuario(String matricula, Usuario usuario) {
        usuarios.put(matricula, usuario);
        return usuario;
    }

    public void removeUsuario(String matricula) {
        usuarios.remove(matricula);
    }

    public Alerta createAlerta(Alerta alerta) {
        alertas.put(alerta.getId(), alerta);
        return alerta;
    }

    public Alerta getAlerta(int id) {
        return alertas.get(id);
    }

    public Alerta updateAlerta(int id, Alerta alerta) {
        alertas.put(id, alerta);
        return alerta;
    }

    public void removeAlerta(int id) {
        alertas.remove(id);
    }
}
