package com.panicButton.panicButton.service;

import com.panicButton.panicButton.handler.VerificaLocalizacaoHandler;
import com.panicButton.panicButton.handler.VerificaPenalidadeHandler;
import com.panicButton.panicButton.state.Ativo;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Sistema {

    //private static Sistema instance;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private EmailService emailService;

    public void setInstance() {
        instance = this;
    }

    private static Sistema instance = null;

    public static Sistema getInstance(){
        if(instance == null){
            instance = new Sistema();
        }
        return instance;
    }

    EstadoConverter estadoConverter = new EstadoConverter();

    public boolean autentificar (String matricula, String email) {
        Optional<Usuario> opt_user = usuarioRepository.findById(matricula);
        if(opt_user.isPresent()) {
            Usuario usuario = opt_user.get();
            if(usuario instanceof Administrador && ((Administrador) usuario).getChave_acesso().equals(email)){
                return true;
            }
            else {
                return usuario.getEmail().equals(email);
            }
        }

        throw new Error("Usuario nao encontrado");
    }

    public Usuario createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setMatricula(usuarioDTO.getMatricula());
        usuario.setAcesso_loc(usuarioDTO.getAcesso_loc());
        usuario.setEstado(estadoConverter.convertToEntityAttribute(usuarioDTO.getEstado()));
        usuario.setLatitude(usuarioDTO.getLatitude());
        usuario.setLongitude(usuarioDTO.getLongitude());

        return usuarioRepository.save(usuario);
    }

    public Administrador createAdministrador(Usuario usuario) {
        Administrador adm = new Administrador();
        adm.setNome(usuario.getNome());
        adm.setMatricula(usuario.getMatricula());
        adm.setAcesso_loc(usuario.getAcesso_loc());
        adm.setEstado(usuario.getEstado());
        adm.setLatitude(usuario.getLatitude());
        adm.setLongitude(usuario.getLongitude());

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
        usuario.setLatitude(usuarioDTO.getLatitude());
        usuario.setLongitude(usuarioDTO.getLongitude());

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> removeUsuario(String matricula) {
        Optional<Usuario> usuario = usuarioRepository.findById(matricula);
        usuario.ifPresent(usuarioRepository::delete);
        return usuario;
    }

    public Alerta createAlerta(AlertaDTO alertaDTO) throws Exception {
        Alerta alerta = new Alerta();
        alerta.setLatitude(alertaDTO.getLatitude());
        alerta.setLongitude(alertaDTO.getLongitude());
        alerta.setMotivo(alertaDTO.getMotivo());
        Usuario usuario = usuarioRepository.findById(alertaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        alerta.setUsuario(usuario);
        alerta.setObservadores(alertaDTO.getObservadores());
        alerta.setAtivo(alertaDTO.getAtivo());

        VerificaLocalizacaoHandler local = new VerificaLocalizacaoHandler();
        VerificaPenalidadeHandler penal = new VerificaPenalidadeHandler();

        local.setNext(penal);
        local.handle(alerta); 

        String body = "Um alerta foi criado por motivo de: " + alertaDTO.getMotivo();

        List<Usuario> usuarios = (List<Usuario>)usuarioRepository.findAll();
        for(Usuario u : usuarios) {
            emailService.sendEmail(u.getEmail(), "Alerta!", body);
        }
        return alertaRepository.save(alerta);



    }
    public Iterable<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Alerta> getAlerta(Usuario usuario) {
        return alertaRepository.findByUsuario(usuario);
    }

    public Iterable<Alerta>  getAlertas() {
        return alertaRepository.findAll();
    }

    public Iterable<Alerta> getAlertasAtivos() {
        return alertaRepository.findAll();
    }

    public Alerta updateAlerta(AlertaDTO alertaDTO) {
        Optional<Alerta> op = alertaRepository.findById(alertaDTO.getId());
        if (op.isEmpty()) {
            throw new RuntimeException("Alerta não encontrado");
        }
        Alerta alerta = op.get();
        alerta.setLatitude(alertaDTO.getLatitude());
        alerta.setLongitude(alertaDTO.getLongitude());
        alerta.setMotivo(alertaDTO.getMotivo());
        Usuario usuario = usuarioRepository.findById(alertaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        alerta.setUsuario(usuario);
        alerta.setObservadores(alertaDTO.getObservadores());
        alerta.setAtivo(alertaDTO.getAtivo());

        return alertaRepository.save(alerta);
    }

    public Optional<Alerta> removeAlerta(Long id) {
        Optional<Alerta> alerta = alertaRepository.findById(id);
        alerta.ifPresent(alertaRepository::delete);
        return alerta;
    }
}