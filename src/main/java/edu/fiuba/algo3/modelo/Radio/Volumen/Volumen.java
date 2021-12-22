package edu.fiuba.algo3.modelo.Radio.Volumen;

import edu.fiuba.algo3.modelo.Evento.RadioListener;

import java.util.ArrayList;
import java.util.List;

public class Volumen {
    private List<RadioListener> oyentes = new ArrayList<>();
    private double volumen;

    public Volumen(double unVolumen) {
        this.volumen = unVolumen;

    }

    public double getVolumen() {
        return this.volumen;
    }

    public void escuchar(RadioListener listener) {
        oyentes.add(listener);
    }
}
