package edu.fiuba.algo3.controlador.Mapa;

import edu.fiuba.algo3.ControladorStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MapaDestinosControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControladorStage controladorStage;

    public MapaDestinosControlador(Juego juego, Mision mision, ControladorStage controladorStage) {
        this.juego = juego;
        this.mision = mision;
        this.controladorStage = controladorStage;
    }

    public void libritoClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        abrirLibro();
    }

    public void libritoKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        abrirLibro();
    }

    private void abrirLibro() {
        /** \todo **/
    }
}
