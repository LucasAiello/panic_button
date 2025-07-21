package com.panicButton.panicButton.service;

import com.panicButton.panicButton.converter.EstadoConverter;
import com.panicButton.panicButton.domain.Administrador;
import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.dto.AlertaDTO;
import com.panicButton.panicButton.dto.UsuarioDTO;
import com.panicButton.panicButton.repository.AdministradorRepository;
import com.panicButton.panicButton.repository.AlertaRepository;
import com.panicButton.panicButton.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class Sistema {
    private static Sistema instance = null;

    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<Long, Alerta> alertas = new HashMap<>();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    EstadoConverter estadoConverter = new EstadoConverter();

    private Sistema() {}

    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setMatricula(usuarioDTO.getMatricula());
        usuario.setAcesso_loc(usuarioDTO.getAcesso_loc());
        usuario.setEstado(estadoConverter.convertToEntityAttribute(usuarioDTO.getEstado()));
        usuario.setPosicao(usuarioDTO.getPosicao());

        return usuarioRepository.save(usuario);
    }

    public Administrador createAdministrador(Usuario usuario) {
        Administrador adm = new Administrador();
        adm.setNome(usuario.getNome());
        adm.setMatricula(usuario.getMatricula());
        adm.setAcesso_loc(usuario.getAcesso_loc());
        adm.setEstado(usuario.getEstado());
        adm.setPosicao(usuario.getPosicao());

        String chaveAcesso = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        adm.setChave_acesso(chaveAcesso);

        return administradorRepository.save(adm);
    }

    public Optional<Usuario> getUsuario(String matricula) {
        return usuarioRepository.findById(matricula);
    }

    public Usuario updateUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = getUsuario(usuarioDTO.getMatricula())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(usuarioDTO.getNome());
        usuario.setMatricula(usuarioDTO.getMatricula());
        usuario.setAcesso_loc(usuarioDTO.getAcesso_loc());
        usuario.setEstado(estadoConverter.convertToEntityAttribute(usuarioDTO.getEstado()));
        usuario.setPosicao(usuarioDTO.getPosicao());

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> removeUsuario(String matricula) {
        Optional<Usuario> usuario = usuarioRepository.findById(matricula);
        usuario.ifPresent(usuarioRepository::delete);
        return usuario;
    }

    public Alerta createAlerta(AlertaDTO alertaDTO) {
        Alerta alerta = new Alerta();
        alerta.setPosicao(alertaDTO.getPosicao());
        alerta.setMotivo(alertaDTO.getMotivo());
        alerta.setUsuario(alertaDTO.getUsuario());
        alerta.setObservadores(alertaDTO.getObservadores());
        return alertaRepository.save(alerta);
    }

    public Optional<Alerta> getAlerta(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta updateAlerta(AlertaDTO alertaDTO) {
        Alerta alerta = getAlerta(alertaDTO.getId())
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));

        alerta.setPosicao(alertaDTO.getPosicao());
        alerta.setMotivo(alertaDTO.getMotivo());
        alerta.setUsuario(alertaDTO.getUsuario());
        alerta.setObservadores(alertaDTO.getObservadores());

        return alertaRepository.save(alerta);
    }

    public Optional<Alerta> removeAlerta(Long id) {
        Optional<Alerta> alerta = alertaRepository.findById(id);
        alerta.ifPresent(alertaRepository::delete);
        return alerta;
    }
}