package edu.fiuba.algo3.controlador.Calendario.Accion;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PantallaAccionControlador extends PantallaControlador {
    private ControlStage controlStage;

    public PantallaAccionControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego,mision,controlStage);
        this.controlStage = controlStage;
    }

    public void fondoClicked(MouseEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(controlStage.sacarPantallaActual()) {
            liberar();
        }
    }

    public void fondoKeyPressed(KeyEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(controlStage.sacarPantallaActual()) {
            liberar();
        }
    }

    @Override
    protected void alCambiarMision(Mision mision) {
        /** No hacer nada. **/
    }
}
