package edu.fiuba.algo3.modelo.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Radio.EstadoTracks.EstadoTracks;

public class EstadoAlimentacion {
    IEstadoAlimentacion estado = new EstadoEncendida();

    public void pulsarBotonPrender() {
        estado = estado.pulsarBotonPrender();
    }

    public boolean estaEncendida() {
        return estado.estaEncendida();
    }

    public int getNumeroTrack(EstadoTracks tracks) {
        return estado.getNumeroTrack(tracks);
    }

    public void pulsarBotonAnterior(EstadoTracks tracks) {
        estado.pulsarBotonAnterior(tracks);
    }

    public void pulsarBotonSiguiente(EstadoTracks tracks) {
        estado.pulsarBotonSiguiente(tracks);
    }
}
