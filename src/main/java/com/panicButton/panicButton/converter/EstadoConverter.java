package com.panicButton.panicButton.converter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.panicButton.panicButton.state.*;

@Converter(autoApply = false)
public class EstadoConverter implements AttributeConverter<iEstado, String> {

    @Override
    public String convertToDatabaseColumn(iEstado attribute) {
        if (attribute instanceof Ativo) return "ATIVO";
        if (attribute instanceof Bloqueado) return "BLOQUEADO";
        if (attribute instanceof Penalizado) return "PENALIZADO";
        return null;
    }

    @Override
    public iEstado convertToEntityAttribute(String dbData) {
        return switch (dbData) {
            case "ATIVO" -> new Ativo();
            case "BLOQUEADO" -> new Bloqueado();
            case "PENALIZADO" -> new Penalizado();
            default -> throw new IllegalArgumentException("Estado desconhecido: " + dbData);
        };
    }
}
