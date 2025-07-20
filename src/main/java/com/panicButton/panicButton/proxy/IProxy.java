package com.panicButton.panicButton.proxy;

import com.panicButton.panicButton.domain.Alerta;
import com.panicButton.panicButton.domain.Usuario;

public interface IProxy {
    Usuario createUsuario(Usuario usuario);
    Alerta getAlerta(int id);
    void removeAlerta(int id);
    Alerta createAlerta(Alerta alerta);
    Alerta updateAlerta(int id, Alerta alerta);
    Usuario getUsuario(String matricula);
    Usuario updateUsuario(String matricula, Usuario usuario);
}
