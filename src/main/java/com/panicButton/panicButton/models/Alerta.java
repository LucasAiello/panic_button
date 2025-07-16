package com.panicButton.panicButton.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;
import java.util.UUID;

@Entity
public class Alerta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String posicao;
    private String motivo;
    private Usuario usuario;
    private List<iObserver> observers;

}
