package edu.fiuba.algo3.modelo.Calendario.Evento;

import java.util.EventListener;

public interface RadioListener extends EventListener {
    void handle(RadioEvento evento);
}

