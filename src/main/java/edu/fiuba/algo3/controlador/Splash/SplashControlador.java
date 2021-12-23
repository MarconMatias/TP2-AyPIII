package edu.fiuba.algo3.controlador.Splash;

import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Splash;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SplashControlador {
    private final Juego juego;
    private Splash splash;
    public EventHandler handler = new EventHandler() {
        @Override
        public void handle(Event event) { /* No hacer nada. */  }
    };

    public SplashControlador(Juego juego) {
        this.juego = juego;
    }

    public void enlazar(Splash splash) {
        this.splash = splash;
        RadioControlador radioControlador = new RadioControlador(juego.getRadio());
        splash.setOnKeyPressed(radioControlador::handleKeyPressed);
    }

    public void enlazarIniciar(EventHandler nuevoHandler) {
        splash.setOnMouseClicked(this::iniciar);
        splash.setOnKeyPressed(this::iniciar);
        handler = nuevoHandler;
    }

    public void iniciar(Event event) {
        handler.handle(event);
    }
}
