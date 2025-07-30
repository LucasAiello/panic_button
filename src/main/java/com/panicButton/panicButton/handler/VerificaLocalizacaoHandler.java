package com.panicButton.panicButton.handler;

import com.panicButton.panicButton.domain.Alerta;

public class VerificaLocalizacaoHandler extends AlertaHandler {

    @Override
    protected void processa(Alerta alerta) throws Exception {
        if (!estaDentroDoIFPB(alerta)) {
            throw new Exception("Alerta fora da área do IFPB.");
        }
        System.out.println("Localização validada.");
    }

    private boolean estaDentroDoIFPB(Alerta alerta) {
        // Verificação real com geometria (mock aqui)
        return true;
    }
}
