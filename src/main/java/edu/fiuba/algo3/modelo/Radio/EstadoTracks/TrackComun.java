package edu.fiuba.algo3.modelo.Radio.EstadoTracks;

public class TrackComun implements IEstadoTrack {
    private final int numeroTrack;
    private final int cantidadTracks;

    public TrackComun(int numeroTrack, int cantidadTracks) {
        this.numeroTrack = numeroTrack;
        this.cantidadTracks = cantidadTracks;
    }

    @Override
    public int getNumeroTrack() {
        return numeroTrack;
    }

    @Override
    public IEstadoTrack getAnterior() {
        int anterior = numeroTrack - 1;
        if(anterior<1) {
            return new SinTrack(cantidadTracks);
        }
        return new TrackComun(anterior, cantidadTracks);
    }

    @Override
    public IEstadoTrack getSiguiente() {
        int siguiente = numeroTrack + 1;
        if(siguiente > cantidadTracks) {
            return new SinTrack(cantidadTracks);
        }
        return new TrackComun(siguiente, cantidadTracks);
    }
}
