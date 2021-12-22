package edu.fiuba.algo3.modelo.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Evento.VolumenCambia;
import edu.fiuba.algo3.modelo.Radio.EstadoTracks.EstadoTracks;
import edu.fiuba.algo3.modelo.Radio.Volumen.Volumen;
import edu.fiuba.algo3.modelo.Radio.Radio;

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

    @Override
    public double getVolumen(Volumen volumen) {
        return volumen.getVolumen();
    }

    public double subirVolumen(Volumen volumen){
        return volumen.getVolumen() + 0.1;
    }

    public double bajarVolumen(Volumen volumen){

        return volumen.getVolumen() - 0.1;
    }
}
