package edu.fiuba.algo3.controlador.Juego;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ControladorAcciones implements IObservadorAcciones {
    public ControladorAcciones(Juego juego, Mision mision, ControlStage controlStage) {
    }

    @Override
    public void accionRealizada(IAccion accion) {
        String nombre = accion.getNombreAccion();
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, nombre, ButtonType.OK);
        alerta.showAndWait();
    }
}
