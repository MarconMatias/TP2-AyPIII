package edu.fiuba.algo3.controlador.Juego;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class AcercaDeControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;
    private List<Runnable> liberadores = new ArrayList<>();

    public AcercaDeControlador(Juego juego, Mision mision, ControlStage controlStage) {
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public void mapitaClicked(MouseEvent ev) {
        if (ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirMapaCiudades(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    public void mapitaKeyPressed(KeyEvent ev) {
        if (ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirMapaCiudades(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    public void edificiosClicked(MouseEvent ev) {
        if (ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirEdificios(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    public void edificiosKeyPressed(KeyEvent ev) {
        if (ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirEdificios(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    public void ordenClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirOrden(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    public void ordenKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirOrden(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    private void liberar() {
        for(Runnable liberador : liberadores) {
            liberador.run();
        }
    }

    public ObservableValue<? extends IObservadorAcciones> getObservadorLiberable() {
        SimpleObjectProperty<IObservadorAcciones> observable = new SimpleObjectProperty<IObservadorAcciones>(
                new ControladorAcciones(juego, mision, controlStage));
        liberadores.add(()->observable.set(null));
        return observable;
    }

    public void volverClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirMenu(juego)) {
            ev.consume();
            liberar();
        }
    }

    public void volverKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirMenu(juego)) {
            ev.consume();
            liberar();
        }
    }
}
