package edu.fiuba.algo3.modelo.Juego.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Juego.Radio.EstadoTracks.EstadoTracks;
import edu.fiuba.algo3.modelo.Juego.Radio.Volumen.Volumen;

public interface IEstadoAlimentacion {
    IEstadoAlimentacion pulsarBotonPrender();

    boolean estaEncendida();

    int getNumeroTrack(EstadoTracks tracks);

    void pulsarBotonAnterior(EstadoTracks tracks);

    void pulsarBotonSiguiente(EstadoTracks tracks);

    double getVolumen(Volumen volumen);

    void subirVolumen(Volumen volumen);

    void bajarVolumen(Volumen volumen);

    void setVolumen(Volumen volumen, double nuevoValor);
}
