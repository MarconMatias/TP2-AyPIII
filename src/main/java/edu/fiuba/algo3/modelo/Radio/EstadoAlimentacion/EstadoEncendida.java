package edu.fiuba.algo3.modelo.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Radio.EstadoTracks.EstadoTracks;
import edu.fiuba.algo3.modelo.Radio.Volumen.Volumen;

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

    public void subirVolumen(Volumen volumen){
        volumen.subirVolumen();
    }

    public void bajarVolumen(Volumen volumen){
        volumen.bajarVolumen();
    }

    @Override
    public void setVolumen(Volumen volumen, double nuevoValor) {
        volumen.setVolumen(nuevoValor);
    }
}
