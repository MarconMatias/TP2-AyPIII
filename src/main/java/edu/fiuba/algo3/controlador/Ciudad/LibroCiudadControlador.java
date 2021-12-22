package edu.fiuba.algo3.controlador.Ciudad;

import edu.fiuba.algo3.ControladorStage;
import edu.fiuba.algo3.controlador.Edificio.EdificiosControlador;
import edu.fiuba.algo3.controlador.Mapa.MapaDestinosControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Edificio.Edificios;
import edu.fiuba.algo3.vista.Mapa.MapaDestinos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LibroCiudadControlador {
    private final Juego juego;
    private final ControladorStage controladorStage;
    private final Mision mision;

    public LibroCiudadControlador(Juego juego, Mision mision, ControladorStage controladorStage) {
        this.juego = juego;
        this.mision = mision;
        this.controladorStage = controladorStage;
    }

    public void mapitaClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        abrirMapa();
    }

    public void mapitaKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        abrirMapa();
    }

    private void abrirMapa() {
        try {
            MapaDestinosControlador controlador = new MapaDestinosControlador(juego, mision, controladorStage);
            MapaDestinos nuevaVista = new MapaDestinos(juego, mision, controlador);
            controladorStage.cambiar(nuevaVista);
            /* liberar() */
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir mapamundi: " + ex, ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void edificiosClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        abrirEdificios();
    }

    public void edificiosKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        abrirEdificios();
    }

    private void abrirEdificios() {
        try {
            EdificiosControlador controlador = new EdificiosControlador(juego, mision, controladorStage);
            Edificios nuevaVista = new Edificios(juego, mision, controlador);
            controladorStage.cambiar(nuevaVista);
            /* liberar() */
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir plano de la ciudad: " + ex, ButtonType.OK);
            alert.showAndWait();
        }
    }
}
