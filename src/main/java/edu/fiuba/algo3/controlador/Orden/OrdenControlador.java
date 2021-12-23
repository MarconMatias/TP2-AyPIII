package edu.fiuba.algo3.controlador.Orden;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Ciudad.LibroCiudadControlador;
import edu.fiuba.algo3.controlador.Juego.ControladorAcciones;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
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
    private final ControlStage controlStage;

    public OrdenControlador(Juego juego, Mision mision, ControlStage controlStage) {
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
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
            LibroCiudadControlador controladorLibro = new LibroCiudadControlador(juego, mision, controlStage);
            LibroCiudad libro = new LibroCiudad(juego, mision, controladorLibro);
            controlStage.cambiar(libro);
            /* liberar() */
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir libro: " + ex, ButtonType.OK);
            alert.showAndWait();
        }
    }

    public OrdenControlador crearControladorSospechosos() {
        return new OrdenControlador(juego,mision, controlStage);
    }

    public IObservadorAcciones getObservadorAcciones() {
        return new ControladorAcciones(juego, mision, controlStage);
    }
}
