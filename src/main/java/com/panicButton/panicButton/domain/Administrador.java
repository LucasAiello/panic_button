package com.panicButton.panicButton.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Usuario
{
    private String chave_acesso;

    public Usuario cadastrarUsuario(String matricula, String nome)
    {
        return new Usuario();
    };
    public boolean bloquearUsuario(String matricula)
    {
        return true;
    };
}
