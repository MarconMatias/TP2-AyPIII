package edu.fiuba.algo3.controlador.Policia;

import edu.fiuba.algo3.ControladorStage;
import edu.fiuba.algo3.controlador.Ciudad.LibroCiudadControlador;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.vista.Ciudad.LibroCiudad;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PoliciaControlador {
    private final Juego juego;
    private final ControladorStage controladorStage;
    private StringProperty nombreProperty = new SimpleStringProperty("");

    public PoliciaControlador(Juego juego, ControladorStage controladorStage) {
        this.juego = juego;
        this.controladorStage = controladorStage;
    }

    public void botonNuevoClicked(MouseEvent mouseEvent) {
        if (1 == mouseEvent.getButton().ordinal()) {
            hacerNuevo();
        }
    }

    public void botonNuevoKeyPressed(KeyEvent keyEvent) {
        if (KeyCode.ENTER == keyEvent.getCode()) {
            hacerNuevo();
        }
    }

    private void hacerNuevo() {
        Policia policia = crearPolicia();
        hacerMision(policia);
    }

    private void hacerMision(Policia policia) {
        try {
            Mision mision = juego.nuevaMision(policia);
            Ciudad ciudad = mision.getCiudadActual();
            LibroCiudadControlador controladorLibro = new LibroCiudadControlador(juego, mision, controladorStage);
            LibroCiudad libro = new LibroCiudad(juego, mision, controladorLibro);
            controladorStage.cambiar(libro);
            /* liberar() */
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "No pudo crearse la misión: " + ex, ButtonType.OK);
            alert.showAndWait();
        }
    }

    private Policia crearPolicia() {
        Policia policia;
        try {
            policia = juego.nuevoPolicia(nombreProperty.get());
        } catch (Exception ex) {

            /** \todo Refactorizar con Excepciones personalizadas **/
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Se produjo un error al crear el policía: " + ex,
                    ButtonType.OK);
            alert.showAndWait();
            return null;
        }
        return policia;
    }

    public void listaPoliciasClicked(MouseEvent event, Policia policiaSeleccionado) {
        if(event.isConsumed() || (null == policiaSeleccionado)) {
            return;
        }
        event.consume();
        hacerMision(policiaSeleccionado);
    }

    public void listaPoliciasKeyPressed(KeyEvent event, Policia policiaSeleccionado) {
        if(event.isConsumed() || (null == policiaSeleccionado)) {
            return;
        }
        switch(event.getCode()) {
            case ENTER: case SPACE:
                event.consume();
                hacerMision(policiaSeleccionado);
                break;
        }
    }

    public void bindNombreProperty(StringProperty textProperty) {
        this.nombreProperty.bind(textProperty);
    }
}
