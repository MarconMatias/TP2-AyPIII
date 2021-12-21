package edu.fiuba.algo3.componentes.FakeLoader;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FakeService extends Service<Void> {
    private final double factor;

    public FakeService(double factor) {
        this.factor = factor;
    }

    @Override
    protected Task<Void> createTask() {
        return new FakeTarea(factor);
    }
}
