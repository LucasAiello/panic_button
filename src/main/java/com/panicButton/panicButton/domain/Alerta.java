package com.panicButton.panicButton.domain;

import com.panicButton.panicButton.observer.iObserver;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alerta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String posicao;
    private String motivo;
    private Usuario usuario;
    private List<iObserver> observadores;

    public void notificarObservadores() {
        for (iObserver obs : observadores) {
            obs.atualizar(this);
        }
    }
}
