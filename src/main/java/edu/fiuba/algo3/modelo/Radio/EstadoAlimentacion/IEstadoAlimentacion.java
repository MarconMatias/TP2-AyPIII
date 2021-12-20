package edu.fiuba.algo3.modelo.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Radio.EstadoTracks.EstadoTracks;
import edu.fiuba.algo3.modelo.Radio.Volumen.Volumen;

public interface IEstadoAlimentacion {
    IEstadoAlimentacion pulsarBotonPrender();

    boolean estaEncendida();

    int getNumeroTrack(EstadoTracks tracks);

    void pulsarBotonAnterior(EstadoTracks tracks);

    void pulsarBotonSiguiente(EstadoTracks tracks);

    double getVolumen(Volumen volumen);
}
