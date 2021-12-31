package edu.fiuba.algo3.componentes.Cargador;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class CargarVistaServicio extends Service<Void> {
    private final double factor;

    public CargarVistaServicio(double factor) {
        this.factor = factor;
    }

    @Override
    protected Task<Void> createTask() {
        return new CargarVistasTarea(factor);
    }
}
