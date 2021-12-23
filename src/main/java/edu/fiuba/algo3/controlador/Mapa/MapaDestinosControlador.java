package edu.fiuba.algo3.controlador.Mapa;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.ControladorAcciones;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Ciudad.DestinoCiudad;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MapaDestinosControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;

    public MapaDestinosControlador(Juego juego, Mision mision, ControlStage controlStage) {
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

    public void destinoElegido(DestinoCiudad destino) {
        System.out.println("Viajando a "+destino.getNombre());
        mision.viajarACiudad(destino.getCiudad());
        if(controlStage.abrirLibroCiudad(juego, mision)) {
            liberar();
        }
    }

    private void liberar() {
        /** Si hubo suscripciones o recursos que liberar, debe hacerse acá. **/
    }

    public IObservadorAcciones getObservadorAcciones() {
        return new ControladorAcciones(juego, mision, controlStage);
    }
}
