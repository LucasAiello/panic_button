package com.panicButton.panicButton.state;

public class Ativo implements iEstado {
    @Override
    public void handle() {
        System.out.println("Usuário está ativo.");
    }
}
