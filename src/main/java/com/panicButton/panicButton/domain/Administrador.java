package com.panicButton.panicButton.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Usuario
{
    private String chave_acesso;

    public Usuario cadastrarUsuario(String matricula, String nome);
    public boolean bloquearUsuario(String matricula);
}
