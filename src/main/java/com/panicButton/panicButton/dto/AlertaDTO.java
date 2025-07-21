package com.panicButton.panicButton.dto;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.observer.iObserver;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Data
public class AlertaDTO {
    private Long id;
    private Point posicao;
    private String motivo;
    private Usuario usuario;
    private List<iObserver> observadores;

    public static AlertaDTO fromAlerta(Alerta alerta) {
        AlertaDTO dto = new AlertaDTO();
        dto.setId(alerta.getId());
        dto.setPosicao(alerta.getPosicao());
        dto.setMotivo(alerta.getMotivo());
        dto.setUsuario(alerta.getUsuario());
        dto.setObservadores(alerta.getObservadores());
        return dto;
    }

}
