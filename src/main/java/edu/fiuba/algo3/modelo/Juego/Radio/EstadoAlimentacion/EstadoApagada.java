package edu.fiuba.algo3.modelo.Juego.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Juego.Radio.EstadoTracks.EstadoTracks;
import edu.fiuba.algo3.modelo.Juego.Radio.Volumen.Volumen;

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

    @Override
    public double getVolumen(Volumen volumen) {
        return 0;
    }

    @Override
    public void subirVolumen(Volumen volumen) {
        /* Nada, está apagada */
    }

    @Override
    public void bajarVolumen(Volumen volumen) {
        /* Nada, está apagada */
    }

    @Override
    public void setVolumen(Volumen volumen, double nuevoValor) {
        /* Nada, está apagada */
    }

}
