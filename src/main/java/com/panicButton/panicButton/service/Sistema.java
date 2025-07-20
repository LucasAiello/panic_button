package com.panicButton.panicButton.service;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.repository.AlertaRepository;
import com.panicButton.panicButton.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class Sistema {
    private static Sistema instance = null;

    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<Long, Alerta> alertas = new HashMap<>();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    private Sistema() {}

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> getUsuario(String matricula) {
        return usuarioRepository.findById(Integer.valueOf(matricula));
    }

    public Usuario updateUsuario(String matricula, Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public Alerta createAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public Optional<Alerta> getAlerta(Long id) {
        return alertaRepository.findById(Integer.valueOf(Math.toIntExact(id)));
    }

    public Alerta updateAlerta(Long id, Alerta alerta) {
        return alerta;
    }

    public void removeAlerta(Alerta alerta) {
        alertaRepository.delete(alerta);
    }
}