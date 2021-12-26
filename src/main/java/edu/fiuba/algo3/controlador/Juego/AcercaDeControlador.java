package edu.fiuba.algo3.controlador.Juego;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class AcercaDeControlador extends PantallaControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;

    public AcercaDeControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego, mision, controlStage);
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
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
