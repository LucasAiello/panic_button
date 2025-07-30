package com.panicButton.panicButton.dto;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;
import com.panicButton.panicButton.observer.iObserver;
import lombok.Data;

import java.util.List;

@Data
public class AlertaDTO {
    private Long id;
    private double longitude;
    private double latitude;
    private String motivo;
    private String usuarioId;
    private List<iObserver> observadores;
    private Integer ativo;

    public static AlertaDTO fromAlerta(Alerta alerta) {
        AlertaDTO dto = new AlertaDTO();
        dto.setId(alerta.getId());
        dto.latitude = alerta.getLatitude();
        dto.longitude = alerta.getLongitude();
        dto.setMotivo(alerta.getMotivo());
        dto.setUsuarioId(alerta.getUsuario().getMatricula());
        dto.setObservadores(alerta.getObservadores());
        dto.setAtivo(alerta.getAtivo());
        return dto;
    }

}
