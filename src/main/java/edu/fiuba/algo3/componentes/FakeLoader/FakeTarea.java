package edu.fiuba.algo3.componentes.FakeLoader;

import javafx.concurrent.Task;

public class FakeTarea extends Task<Void> {
    private final double factor;

    public FakeTarea(double factor) {
        this.factor = factor;
    }

    @Override
    protected Void call() throws Exception {
        int progreso = 0;
        int maximo = 300;
        for(int tarea = 0; tarea<100; tarea++) {
            int demora = (tarea%5) + 1;
            if(0 == tarea%2) {
                demora = 6 - demora;
            }
            Thread.sleep((long) (demora*factor));
            progreso += demora;
            updateProgress(progreso,maximo);
        }
        this.done();
        return null;
    }
}
