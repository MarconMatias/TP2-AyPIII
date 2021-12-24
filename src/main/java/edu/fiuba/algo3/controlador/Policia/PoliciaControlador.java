package edu.fiuba.algo3.controlador.Policia;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PoliciaControlador {
    private final Juego juego;
    private final ControlStage controlStage;
    private StringProperty nombreProperty = new SimpleStringProperty("");

    public PoliciaControlador(Juego juego, ControlStage controlStage) {
        this.juego = juego;
        this.controlStage = controlStage;
    }

    public void botonNuevoClicked(MouseEvent event) {
        if (1 == event.getButton().ordinal()) {
            if(hacerNuevo()) {
                event.consume();
                liberar();
            }
        }
    }

    public void botonNuevoKeyPressed(KeyEvent event) {
        if (KeyCode.ENTER == event.getCode()) {
            if(hacerNuevo()) {
                event.consume();
                liberar();
            }
        }
    }

    private boolean hacerNuevo() {
        Policia policia = crearPolicia();
        if(null != policia) {
            return controlStage.abrirMisionNueva(juego, policia);
        } else {
            return false;
        }
    }

    private Policia crearPolicia() {
        Policia policia;
        try {
            return juego.nuevoPolicia(nombreProperty.get());
        } catch (Exception ex) {

            /** \todo Refactorizar con Excepciones personalizadas **/
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Se produjo un error al crear el policía: " + ex,
                    ButtonType.OK);
            alert.showAndWait();
            return null;
        }
    }

    public void listaPoliciasClicked(MouseEvent event, Policia policiaSeleccionado) {
        if(event.isConsumed() || (null == policiaSeleccionado)) {
            return;
        }
        if(controlStage.abrirMisionNueva(juego, policiaSeleccionado)) {
            event.consume();
            liberar();
        }
    }

    public void listaPoliciasKeyPressed(KeyEvent event, Policia policiaSeleccionado) {
        if(event.isConsumed() || (null == policiaSeleccionado)) {
            return;
        }
        switch(event.getCode()) {
            case ENTER: case SPACE:
                if(controlStage.abrirMisionNueva(juego, policiaSeleccionado)) {
                    event.consume();
                    liberar();
                }
                break;
        }
    }

    private void liberar() {
        /** Si hubo suscripciones o recursos que liberar, debe hacerse acá. **/
    }

    public void bindNombreProperty(StringProperty textProperty) {
        this.nombreProperty.bind(textProperty);
    }

    public void tarjetasClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirAcercaDe(juego, null)) {
            ev.consume();
            liberar();
        }
    }

    public void tarjetasKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirAcercaDe(juego, null)) {
            ev.consume();
            liberar();
        }
    }
}
