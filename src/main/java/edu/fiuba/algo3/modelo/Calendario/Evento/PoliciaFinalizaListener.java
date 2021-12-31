package edu.fiuba.algo3.modelo.Calendario.Evento;

import java.util.EventListener;

public interface PoliciaFinalizaListener extends EventListener {
    void handle(PoliciaFinaliza evento);
}
