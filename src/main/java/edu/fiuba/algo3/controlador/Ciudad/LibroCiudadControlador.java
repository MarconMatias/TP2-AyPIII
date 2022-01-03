package edu.fiuba.algo3.controlador.Ciudad;

import edu.fiuba.algo3.controlador.ControlStage;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LibroCiudadControlador extends PantallaControlador {
    private final Juego juego;
    private final ControlStage controlStage;
    private final Mision mision;

    public LibroCiudadControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego, mision, controlStage);
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public void volverClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        volver(ev);
    }

    public void volverKeyPressed(KeyEvent ev) {
        if (ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        volver(ev);
    }

    private void volver(InputEvent ev) {
        try {
            if (cancelarMisionConfirmando()) {
                ev.consume();
                liberar();
            }
        } catch (Exception ex) {
            alertaError(ex);
        }
    }

    public boolean cancelarMisionConfirmando() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "¿Desea cancelar la misión actual?", ButtonType.YES, ButtonType.NO);
        ButtonType respuesta = alerta.showAndWait().orElse(ButtonType.NO);
        return respuesta.equals(ButtonType.YES) && controlStage.abrirMenu();
    }
}
