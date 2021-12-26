package edu.fiuba.algo3.controlador.Orden;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import javafx.event.ActionEvent;

public class OrdenControlador extends PantallaControlador {
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

    public SospechososControlador crearControladorSospechosos() {
        return new SospechososControlador(juego,mision, this::sospechosoElegido);
    }

    public void sospechosoElegido(Ladron elegido) {
        if(controlStage.abrirExpediente(juego, mision, elegido))
        {
            liberar();
        }
    }
}
