package edu.fiuba.algo3.modelo.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Radio.EstadoTracks.EstadoTracks;

public class EstadoApagada implements IEstadoAlimentacion {
    @Override
    public IEstadoAlimentacion pulsarBotonPrender() {
        return new EstadoEncendida();
    }

    @Override
    public boolean estaEncendida() {
        return false;
    }

    @Override
    public int getNumeroTrack(EstadoTracks tracks) {
        return 0;
    }

    @Override
    public void pulsarBotonAnterior(EstadoTracks tracks) {
        /* Nada, está apagada. */
    }

    @Override
    public void pulsarBotonSiguiente(EstadoTracks tracks) {
        /* Nada, está apagada. */
    }
}
