package edu.fiuba.algo3.modelo.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Radio.EstadoTracks.EstadoTracks;

public class EstadoEncendida implements IEstadoAlimentacion {
    @Override
    public IEstadoAlimentacion pulsarBotonPrender() {
        return new EstadoApagada();
    }

    @Override
    public boolean estaEncendida() {
        return true;
    }

    @Override
    public int getNumeroTrack(EstadoTracks tracks) {
        return tracks.getNumeroTrack();
    }

    @Override
    public void pulsarBotonAnterior(EstadoTracks tracks) {
        tracks.pulsarBotonAnterior();
    }

    @Override
    public void pulsarBotonSiguiente(EstadoTracks tracks) {
        tracks.pulsarBotonSiguiente();
    }


}
