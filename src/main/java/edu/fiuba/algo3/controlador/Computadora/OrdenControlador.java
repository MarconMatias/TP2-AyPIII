package edu.fiuba.algo3.controlador.Computadora;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.event.ActionEvent;

public class OrdenControlador extends DocumentosControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;

    public OrdenControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego,mision,controlStage);
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public void emitir(ActionEvent ev) {
        mision.generarOrdenDeArresto();
        ev.consume();
   }
}
