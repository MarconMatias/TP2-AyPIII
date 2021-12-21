package edu.fiuba.algo3.modelo.Radio.EstadoTracks;

import edu.fiuba.algo3.componentes.bindings.Point2DBindingXY;
import edu.fiuba.algo3.modelo.Evento.RadioEvento;
import edu.fiuba.algo3.modelo.Evento.RadioListener;
import edu.fiuba.algo3.modelo.Evento.TrackCambia;
import edu.fiuba.algo3.modelo.Radio.Radio;

import java.util.ArrayList;
import java.util.List;

public class EstadoTracks {
    private final int cantidadTracks = 3;
    private IEstadoTrack estado = new TrackComun(1,cantidadTracks);
    private List<RadioListener> oyentesTracks = new ArrayList<RadioListener>();
    private final Radio radio;

    public EstadoTracks(Radio radio) {
        this.radio = radio;
    }

    public int getNumeroTrack() {
        return estado.getNumeroTrack();
    }

    public void pulsarBotonAnterior() {
        int anterior = getNumeroTrack();
        estado = estado.getAnterior();
        notificarOyentesTracks(anterior);
    }

    private void notificarOyentesTracks(int anterior) {
        int actual = getNumeroTrack();
        if(actual == anterior) {
            return;
        }
        RadioEvento evento = new TrackCambia(radio, actual);
        for(RadioListener listener : oyentesTracks) {
            try {
                listener.handle(evento);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void pulsarBotonSiguiente() {
        int anterior = getNumeroTrack();
        estado = estado.getSiguiente();
        notificarOyentesTracks(anterior);
    }

    public void escucharTracks(RadioListener listener) {
        oyentesTracks.add(listener);
    }
}
