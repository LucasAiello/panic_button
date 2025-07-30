package com.panicButton.panicButton.handler;

import com.panicButton.panicButton.domain.Alerta;
import org.springframework.stereotype.Service;

@Service
public abstract class AlertaHandler {
    protected AlertaHandler next;

    public AlertaHandler setNext(AlertaHandler next) {
        this.next = next;
        return next;
    }

    public void handle(Alerta alerta) throws Exception {
        processa(alerta);
        if (next != null) {
            next.handle(alerta);
        }
    }

    protected abstract void processa(Alerta alerta) throws Exception;
}
