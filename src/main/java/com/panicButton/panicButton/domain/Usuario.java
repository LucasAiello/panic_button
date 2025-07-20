package com.panicButton.panicButton.domain;
import com.panicButton.panicButton.state.iEstado;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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