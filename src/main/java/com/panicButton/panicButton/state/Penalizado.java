package com.panicButton.panicButton.state;

public class Penalizado implements iEstado {
    @Override
    public void handle() {
        System.out.println("Usuário está penalizado.");
    }
}
