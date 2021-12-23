package edu.fiuba.algo3.modelo.Radio.Volumen;

import edu.fiuba.algo3.modelo.Evento.RadioListener;
import edu.fiuba.algo3.modelo.Evento.VolumenCambia;
import edu.fiuba.algo3.modelo.Radio.Radio;

import java.util.ArrayList;
import java.util.List;

public class Volumen {
    private final Radio radio;
    private List<RadioListener> oyentes = new ArrayList<>();
    private double volumen;

    public Volumen(Radio radio, double unVolumen) {
        this.volumen = unVolumen;
        this.radio = radio;
    }

    public double getVolumen() {
        return this.volumen;
    }

    public void escuchar(RadioListener listener) {
        oyentes.add(listener);
    }

    public void subirVolumen() {
        setVolumen(volumen + 0.1);
    }

    public void bajarVolumen() {
        setVolumen(volumen - 0.1);
    }

    public void setVolumen(double nuevoVolumen){
        nuevoVolumen = Math.max(0, Math.min(1,nuevoVolumen));
        if(nuevoVolumen == volumen) {
            return;
        }
        VolumenCambia evento =  new VolumenCambia(radio, nuevoVolumen);
        volumen = nuevoVolumen;
        for(RadioListener listener : oyentes) {
            try {
                listener.handle(evento);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
