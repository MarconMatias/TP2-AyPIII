package edu.fiuba.algo3.controlador.Ciudad;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.ControladorAcciones;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LibroCiudadControlador {
    private final Juego juego;
    private final ControlStage controlStage;
    private final Mision mision;

    public LibroCiudadControlador(Juego juego, Mision mision, ControlStage controlStage) {
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
        /** Si hubo suscripciones o recursos que liberar, debe hacerse acá. **/
    }

    public IObservadorAcciones getObservadorAcciones() {
        return new ControladorAcciones(juego, mision, controlStage);
    }
}
