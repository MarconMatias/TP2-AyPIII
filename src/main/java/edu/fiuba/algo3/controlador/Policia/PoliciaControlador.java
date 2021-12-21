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
        if(1 == mouseEvent.getButton().ordinal()) {
            hacerNuevo();
        }
    }

    public void botonNuevoKeyPressed(KeyEvent keyEvent) {
        if(KeyCode.ENTER==keyEvent.getCode()) {
            hacerNuevo();
        }
    }

    private void hacerNuevo() {
        /** \todo Refactorizar con Excepciones personalizadas y un solo try-catch. **/
        Policia policia;
        try {
            policia = juego.nuevoPolicia(nombreProperty.get());
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Se produjo un error al crear el policía: "+ex, ButtonType.OK);
            alert.showAndWait();
            return;
        }
        try {
            Mision mision = juego.nuevaMision(policia);
            Ciudad ciudad = mision.getCiudadActual();
            LibroCiudadControlador controladorLibro = new LibroCiudadControlador(juego, mision, controladorStage);
            LibroCiudad libro = new LibroCiudad(ciudad, controladorLibro);
            libro.setRadio(juego.getRadio());
            controladorStage.cambiar(libro);
            /* liberar() */
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "El policía fue creado pero no pudo crearse la misión: "+ex, ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void listaPoliciasClicked(MouseEvent mouseEvent) {
    }

    public void listaPoliciasKeyPressed(KeyEvent keyEvent) {
    }

    public void bindNombreProperty(StringProperty textProperty) {
        this.nombreProperty.bind(textProperty);
    }
}
