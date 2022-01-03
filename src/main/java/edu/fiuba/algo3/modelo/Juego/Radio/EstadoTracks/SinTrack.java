package edu.fiuba.algo3.modelo.Juego.Radio.EstadoTracks;

public class SinTrack implements IEstadoTrack {
    private final int cantidadTracks;

    public SinTrack(int cantidadTracks) {
        this.cantidadTracks = cantidadTracks;
    }

    @Override
    public int getNumeroTrack() {
        return 0;
    }

    @Override
    public IEstadoTrack getAnterior() {
        return new TrackComun(cantidadTracks-1, cantidadTracks);
    }

    @Override
    public IEstadoTrack getSiguiente() {
        return new TrackComun(1,cantidadTracks);
    }
}
