package com.panicButton.panicButton.state;

public class Bloqueado implements iEstado {
    @Override
    public void handle() {
        System.out.println("Usuário está bloqueado.");
    }
}
