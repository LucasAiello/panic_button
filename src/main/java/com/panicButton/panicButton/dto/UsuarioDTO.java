package com.panicButton.panicButton.dto;

import com.panicButton.panicButton.domain.Administrador;
import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.converter.EstadoConverter;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Data
public class UsuarioDTO {
    private String matricula;
    private String nome;
    private boolean acesso_loc;
    private String estado;
    private double longitude;
    private double latitude;
    private boolean admin;
    private List<Alerta> alertas;

    public static UsuarioDTO fromUsuario(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.matricula = usuario.getMatricula();
        dto.nome = usuario.getNome();
        dto.acesso_loc = usuario.getAcesso_loc();
        dto.estado = new EstadoConverter().convertToDatabaseColumn(usuario.getEstado());
        dto.longitude = usuario.getLongitude();
        dto.latitude = usuario.getLatitude();
        dto.admin = usuario instanceof Administrador;
        return dto;
    }
    public boolean getAcesso_loc() {
        return acesso_loc;
    }
}
