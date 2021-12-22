package edu.fiuba.algo3.modelo.Computadora.Evento;

import java.util.EventListener;

public interface ComputadoraListener extends EventListener {
    void handle(ComputadoraEvento evento);
}
