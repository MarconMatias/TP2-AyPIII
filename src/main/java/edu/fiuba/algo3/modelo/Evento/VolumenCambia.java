package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Radio.Radio;

public class VolumenCambia extends RadioEvento {
    private final double volumen;

    /**
     * Construye un evento emitido por Radio.
     *
     * @param radio La radio que emite el evento.
     * @param nuevo El nuevo nivel de volumen.
     * @throws IllegalArgumentException si radio es null
     */
    public VolumenCambia(Radio radio, double nuevo) {
        super(radio);
        this.volumen = nuevo;
    }

    public double getVolumen() {
        return volumen;
    }
}
