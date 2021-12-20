package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Radio.Radio;

import java.util.EventObject;

public abstract class RadioEvento  extends EventObject {

    /**
     * Construye un evento emitido por Radio.
     *
     * @param radio La radio que emite el evento.
     * @throws IllegalArgumentException si radio es null
     */
    public RadioEvento(Radio radio) {
        super(radio);
    }
}