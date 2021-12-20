package edu.fiuba.algo3.controlador.Splash;

import edu.fiuba.algo3.vista.Splash;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SplashControlador {
    private final Splash splash;
    public EventHandler handler = new EventHandler() {
        @Override
        public void handle(Event event) { /* No hacer nada. */  }
    };

    public SplashControlador(Splash splash) {
        this.splash = splash;
        splash.setOnMouseClicked(this::iniciar);
        splash.setOnKeyPressed(this::iniciar);
    }

    public void bind(EventHandler nuevoHandler) {
        handler = nuevoHandler;
    }

    private void iniciar(Event event) {
        handler.handle(event);
    }
}
