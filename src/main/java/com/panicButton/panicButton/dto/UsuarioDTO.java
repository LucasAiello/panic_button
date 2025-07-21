package com.panicButton.panicButton.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String matricula;
    private String nome;
    private boolean acesso_loc;
    private String estado;
}
