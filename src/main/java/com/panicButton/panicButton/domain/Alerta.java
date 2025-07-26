package com.panicButton.panicButton.domain;

import org.locationtech.jts.geom.Point;
import com.panicButton.panicButton.observer.iObserver;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alerta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double longitude;
    private double latitude;

    private String motivo;
    @ManyToOne
    private Usuario usuario;
    @Transient
    private List<iObserver> observadores;

    public void notificarObservadores() {
        for (iObserver obs : observadores) {
            obs.atualizar(this);
        }
    }
}
