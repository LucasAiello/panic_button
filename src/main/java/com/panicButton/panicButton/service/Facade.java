package com.panicButton.panicButton.service;

import com.panicButton.panicButton.domain.Alerta;

public class Facade {
    private Alerta alerta;

    public Facade(Alerta alerta) {
        this.alerta = alerta;
    }

    public void processarAlerta() {
        alerta.notificarObservadores();
        System.out.println("Alerta processado.");
    }
}
