package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Radio.Radio;

public class TrackCambia extends RadioEvento {
    private final int track;

    /**
     * Construye un evento emitido por Radio cuando el track cambia.
     *
     * @param radio La radio que emite el evento.
     * @param track El número de track.
     * @throws IllegalArgumentException si radio es null
     */
    public TrackCambia(Radio radio, int track) {
        super(radio);
        this.track = track;
    }

    public int getNumeroTrack() {
        return this.track;
    }
}
