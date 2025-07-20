package com.panicButton.panicButton.service;

import com.panicButton.panicButton.domain.Alerta;

public class Facade {
    private Alerta alerta;

    public Facade(Alerta alerta) {
        this.alerta = alerta;
    }

    public void processarAlerta() {
        // Aqui você pode aplicar as verificações da cadeia, notificação etc.
        alerta.notificarObservadores();
        // Poderia também logar, chamar handlers, aplicar regras de estado, etc.
        System.out.println("Alerta processado via Facade.");
    }
}
