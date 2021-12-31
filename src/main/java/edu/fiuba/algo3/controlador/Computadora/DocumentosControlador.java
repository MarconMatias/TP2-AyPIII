package edu.fiuba.algo3.controlador.Computadora;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class DocumentosControlador extends PantallaControlador {

    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;

    public DocumentosControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego,mision,controlStage);
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public DetallesControlador crearControladorDetalles() {
        return new DetallesControlador(juego, mision);
    }

    public SospechososControlador crearControladorSospechosos() {
        return new SospechososControlador(juego,mision, this::sospechosoElegido);
    }

    public void ordenClicked(MouseEvent ev) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirOrden()) {
            ev.consume();
            liberar();
        }
    }

    public void ordenKeyPressed(KeyEvent ev) {
        if(ev.isConsumed() || (KeyCode.ENTER != ev.getCode())) {
            return;
        }
        if(controlStage.abrirOrden()) {
            ev.consume();
            liberar();
        }
    }

    public void sospechosoElegido(Ladron elegido) {
        if((null!=elegido) && controlStage.abrirExpediente(elegido))
        {
            liberar();
        }
    }

}
