package com.panicButton.panicButton.dto;

import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.converter.EstadoConverter;
import lombok.Data;

@Data
public class UsuarioDTO {
    public String matricula;
    public String nome;
    public boolean acesso_loc;
    public String estado;

    public static UsuarioDTO fromUsuario(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.matricula = usuario.getMatricula();
        dto.nome = usuario.getNome();
        dto.acesso_loc = usuario.getAcesso_loc();
        dto.estado = new EstadoConverter().convertToDatabaseColumn(usuario.getEstado());
        return dto;
    }
    public boolean getAcesso_loc() {
        return acesso_loc;
    }
}
