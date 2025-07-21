package com.panicButton.panicButton.domain;
import com.panicButton.panicButton.converter.EstadoConverter;
import com.panicButton.panicButton.state.iEstado;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.locationtech.jts.geom.Point;


@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario
{
    @Id
    private String matricula;
    private String nome;
    private boolean acesso_loc;
    @Convert(converter = EstadoConverter.class)
    private iEstado estado;
    private Point posicao;

    public Alerta criarAlerta()
    {
      return new Alerta();
    };
    public void concluirAlerta(Long id){};
    public void permitirAcessoLoc(){};

    public boolean getAcesso_loc() {
        return acesso_loc;
    }
}