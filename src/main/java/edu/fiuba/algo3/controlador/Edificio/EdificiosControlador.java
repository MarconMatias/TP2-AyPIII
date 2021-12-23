package edu.fiuba.algo3.controlador.Edificio;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.ControladorAcciones;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Edificio.DestinoEdificio;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class EdificiosControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;

    public EdificiosControlador(Juego juego, Mision mision, ControlStage controlStage) {
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public void libritoClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirLibroCiudad(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    public void libritoKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirLibroCiudad(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    private void liberar() {
        /** Si hubo suscripciones o recursos que liberar, debe hacerse acá. **/
    }

    public void destinoElegido(DestinoEdificio destino) {
        Edificio edificio = destino.getEdificio();
        System.out.println("Visitando edificio "+edificio.getNombre());
        String testimonio = mision.visitarEdificio(edificio);
        String testigo = mision.getTestigo(edificio);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, testigo+" dice:\n" + testimonio);
        alerta.showAndWait();
    }

    public IObservadorAcciones getObservadorAcciones() {
        return new ControladorAcciones(juego, mision, controlStage);
    }

}
