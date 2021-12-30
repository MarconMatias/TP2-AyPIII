package edu.fiuba.algo3.controlador.Juego.Final;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PantallaFinalControlador extends PantallaControlador {
    public PantallaFinalControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego, mision, controlStage);
    }

    public void fondoClicked(MouseEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(controlStage.abrirMenu()) {
            liberar();
        }
    }

    public void fondoKeyPressed(KeyEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(controlStage.abrirMenu()) {
            liberar();
        }
    }
}
