package edu.fiuba.algo3.controlador.Juego;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class PantallaControlador {

    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;
    private List<Runnable> liberadores = new ArrayList<>();

    public PantallaControlador(Juego juego, Mision mision, ControlStage controlStage) {
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    /**
     * Abre la ventana de acerca de correspondiente a esta pantalla.
     * En la clase base abre la versión para volver a la misión abierta,
     * en caso de que no sea así debe sobrecargarse.
     * @param ev Evento que disparó la acción.
     * @return Si cambió la pantalla exitosamente.
     */
    protected boolean abrirAcercaDe(InputEvent ev) {
        return controlStage.abrirAcercaDe(juego, mision);
    }

    /**
     * Agrega un método a invocar cuando cambia de pantalla.
     * @param liberador Método a invocar.
     */
    protected void agregarLiberador(Runnable liberador) {
        liberadores.add(liberador);
    }

    /**
     * Si el evento no fue consumido, procesa un click en el plano
     * de edificios; y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void edificiosClicked(MouseEvent ev) {
        if (ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirEdificios(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa una tecla presionada en el
     * plano de edificios; y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void edificiosKeyPressed(KeyEvent ev) {
        if (ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirEdificios(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    public ObservableValue<? extends IObservadorAcciones> getObservadorLiberable() {
        SimpleObjectProperty<IObservadorAcciones> observable = new SimpleObjectProperty<IObservadorAcciones>(
                new ControladorAcciones(juego, mision, controlStage));
        agregarLiberador(()->observable.set(null));
        return observable;
    }

    /**
     * Libera suscripciones a observadores u otros recursos cuando pasa a otra pantalla.
     * Esta clase base libera los liberadores registrados en agregarLiberador().
     * Cada clase que desciende peude sobrecargar si lo necesita y llamar a super.liberar().
     */
    protected void liberar() {
        for(Runnable liberador : liberadores) {
            liberador.run();
        }
    }

    /**
     * Si el evento no fue consumido, procesa un click en el libro
     * de ciudad actual; y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void libritoClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirLibroCiudad(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa una tecla presionada en el
     * libro de ciudad actual; y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void libritoKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirLibroCiudad(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa el click en el
     * mapa de ciudades; y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void mapitaClicked(MouseEvent ev) {
        if (ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirMapaCiudades(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa una tecla presionada en el
     * mapa de ciudad; y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void mapitaKeyPressed(KeyEvent ev) {
        if (ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirMapaCiudades(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa el click en la orden de arresto;
     * y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void ordenClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirOrden(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa una tecla presionada en la orden de arresto;
     * y en caso de éxito lo marca como consumido.
     * @param ev Evento que disparó la acción.
     */
    public void ordenKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirOrden(juego, mision)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa el click en las tarjetas; y en
     * caso de éxito lo marca como consumido.
     * En esta clase base, invoca al método de este controlador abrirAcercaDe.
     * @param ev Evento que disparó la acción.
     */
    public void tarjetasClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(abrirAcercaDe(ev)) {
            ev.consume();
            liberar();
        }
    }

    /**
     * Si el evento no fue consumido, procesa el presionar una tecla en las tarjetas;
     *  y en caso de éxito lo marca como consumido.
     * En esta clase base, invoca al método de este controlador abrirAcercaDe.
     * @param ev Evento que disparó la acción.
     */
    public void tarjetasKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(abrirAcercaDe(ev)) {
            ev.consume();
            liberar();
        }
    }
}
