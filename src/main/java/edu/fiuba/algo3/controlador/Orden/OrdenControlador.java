package edu.fiuba.algo3.controlador.Orden;

import edu.fiuba.algo3.ControladorStage;
import edu.fiuba.algo3.controlador.Ciudad.LibroCiudadControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Ciudad.LibroCiudad;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class OrdenControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControladorStage controladorStage;

    public OrdenControlador(Juego juego, Mision mision, ControladorStage controladorStage) {
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
        try {
            LibroCiudadControlador controladorLibro = new LibroCiudadControlador(juego, mision, controladorStage);
            LibroCiudad libro = new LibroCiudad(juego, mision, controladorLibro);
            controladorStage.cambiar(libro);
            /* liberar() */
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir libro: " + ex, ButtonType.OK);
            alert.showAndWait();
        }
    }

}
