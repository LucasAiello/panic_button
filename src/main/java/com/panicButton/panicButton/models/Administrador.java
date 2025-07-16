package com.panicButton.panicButton.models;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Usuario
{
    private String chave_acesso;

    public Usuario cadastrarUsuario(String matricula, String nome);
    public boolean bloquearUsuario(String matricula);
}
