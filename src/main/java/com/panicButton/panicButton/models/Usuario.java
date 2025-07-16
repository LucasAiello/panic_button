package com.panicButton.panicButton.models;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Usuario
{
    @Id
    private String matricula;
    private String nome;
    private boolean acesso_loc;
    private iEstado estado;

    public Alerta criarAlerta();
    public concluirAlerta(UUID id);
    public void permitirAcessoLoc();
}