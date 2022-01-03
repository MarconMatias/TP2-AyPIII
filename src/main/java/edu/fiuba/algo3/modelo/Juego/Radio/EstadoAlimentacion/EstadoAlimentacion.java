package edu.fiuba.algo3.modelo.Juego.Radio.EstadoAlimentacion;

import edu.fiuba.algo3.modelo.Calendario.Evento.RadioListener;
import edu.fiuba.algo3.modelo.Calendario.Evento.VolumenCambia;
import edu.fiuba.algo3.modelo.Juego.Radio.EstadoTracks.EstadoTracks;
import edu.fiuba.algo3.modelo.Juego.Radio.Radio;
import edu.fiuba.algo3.modelo.Juego.Radio.Volumen.Volumen;

import java.util.ArrayList;
import java.util.List;

public class EstadoAlimentacion {
    IEstadoAlimentacion estado = new EstadoEncendida();
    private List<RadioListener> oyentes = new ArrayList<>();
    private final Radio radio;

    public EstadoAlimentacion(Radio radio) {
        this.radio = radio;
    }

    public void pulsarBotonPrender() {
        estado = estado.pulsarBotonPrender();

        VolumenCambia evento =  new VolumenCambia(radio, radio.getVolumen());
        for(RadioListener listener : oyentes) {
            try {
                listener.handle(evento);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
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

    public void subirVolumen(Volumen volumen) {
        estado.subirVolumen(volumen);
    }

    public void bajarVolumen(Volumen volumen) {
        estado.bajarVolumen(volumen);
    }

    public void setVolumen(Volumen volumen, double nuevoValor) {
        estado.setVolumen(volumen,nuevoValor);
    }

    public void escuchar(RadioListener listener) {
        oyentes.add(listener);
    }
}
