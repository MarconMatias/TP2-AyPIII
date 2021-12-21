package edu.fiuba.algo3.modelo.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Evento.VolumenCambia;
import edu.fiuba.algo3.modelo.Radio.Radio;
import edu.fiuba.algo3.modelo.Radio.EstadoTracks.EstadoTracks;
import edu.fiuba.algo3.modelo.Radio.Volumen.Volumen;

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

    public double getVolumen(Volumen volumen) {
        return estado.getVolumen(volumen);
    }

    public double subirVolumen(Radio radio,Volumen volumen) {
        VolumenCambia nuevo_volumen =  new VolumenCambia(radio, estado.subirVolumen(volumen));
        return nuevo_volumen.getVolumen();     
    }

    public double bajarVolumen(Radio radio,Volumen volumen) {
        VolumenCambia nuevo_volumen = new VolumenCambia(radio, estado.bajarVolumen(volumen));
        return nuevo_volumen.getVolumen();         
    }
}
