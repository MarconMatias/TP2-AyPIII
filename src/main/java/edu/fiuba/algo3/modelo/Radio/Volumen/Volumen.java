package edu.fiuba.algo3.modelo.Radio.Volumen;

import edu.fiuba.algo3.modelo.Evento.RadioListener;

import java.util.ArrayList;
import java.util.List;

public class Volumen {
    private List<RadioListener> oyentes = new ArrayList<>();

    public Volumen(double volumen) {
    }

    public double getVolumen() {
        return 0.5;
    }

    public void escuchar(RadioListener listener) {
        oyentes.add(listener);
    }
}
