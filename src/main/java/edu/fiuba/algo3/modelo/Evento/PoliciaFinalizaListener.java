package edu.fiuba.algo3.modelo.Evento;

import java.util.EventListener;

public interface PoliciaFinalizaListener extends EventListener {
    void handle(PoliciaFinaliza evento);
}
