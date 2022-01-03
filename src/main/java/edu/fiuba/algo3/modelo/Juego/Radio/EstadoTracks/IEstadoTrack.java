package edu.fiuba.algo3.modelo.Juego.Radio.EstadoTracks;

public interface IEstadoTrack {
    int getNumeroTrack();

    IEstadoTrack getAnterior();

    IEstadoTrack getSiguiente();
}
