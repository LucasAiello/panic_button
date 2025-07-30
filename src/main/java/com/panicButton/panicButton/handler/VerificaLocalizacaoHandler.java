package com.panicButton.panicButton.handler;

import com.panicButton.panicButton.domain.Alerta;
import org.locationtech.jts.geom.*;

public class VerificaLocalizacaoHandler extends AlertaHandler {

    GeometryFactory geometryFactory = new GeometryFactory();

    static final Coordinate[] coords = new Coordinate[] {
            new Coordinate(-7.238372714431187, -35.91495364062937),
            new Coordinate(-7.239280057653925, -35.91720937834884),
            new Coordinate(-7.240870418729719, -35.913960759230775),
            new Coordinate(-7.241666958311792, -35.916112467917074),
            new Coordinate(-7.238372714431187, -35.91495364062937) // fechar poligono
    };
    @Override
    protected void processa(Alerta alerta) throws Exception {
        if (!estaDentroDoIFPB(alerta)) {
            throw new Exception("Alerta fora da área do IFPB.");
        }
        System.out.println("Localização validada.");
    }

    private boolean estaDentroDoIFPB(Alerta alerta) {
        LinearRing shell = geometryFactory.createLinearRing(coords);
        Polygon quadrilatero = geometryFactory.createPolygon(shell, null);
        Point ponto = geometryFactory.createPoint(new Coordinate(alerta.getLatitude(), alerta.getLongitude()));
        if(quadrilatero.contains(ponto))
            return true;
        return false;
    }
}
