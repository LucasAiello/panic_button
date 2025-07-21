package com.panicButton.panicButton.dto;

import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.observer.iObserver;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Data
public class AlertaDTO {
    private Point posicao;
    private String motivo;
    private Usuario usuario;
    private List<iObserver> observadores;
}
