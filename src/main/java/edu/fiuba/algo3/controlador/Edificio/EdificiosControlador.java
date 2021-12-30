package edu.fiuba.algo3.controlador.Edificio;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.ControladorAcciones;
import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Edificio.DestinoEdificio;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class EdificiosControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;
    private List<Runnable> liberadores = new ArrayList<>();

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

    public void destinoElegido(DestinoEdificio destino) throws AccionException, CalendarioException {
        Edificio edificio = destino.getEdificio();
        System.out.println("Visitando edificio "+edificio.getNombre());
        String testimonio = mision.visitarEdificio(edificio);
        String testigo = mision.getTestigo(edificio);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, testigo+" dice:\n" + testimonio);
        alerta.showAndWait();
    }


    private void liberar() {
        for(Runnable liberador : liberadores) {
            liberador.run();
        }
    }

    public ObservableValue<? extends IObservadorAcciones> getObservadorLiberable() {
        SimpleObjectProperty<IObservadorAcciones> observable = new SimpleObjectProperty<IObservadorAcciones>(
                new ControladorAcciones(juego, mision, controlStage));
        liberadores.add(()->observable.set(null));
        return observable;
    }

}
