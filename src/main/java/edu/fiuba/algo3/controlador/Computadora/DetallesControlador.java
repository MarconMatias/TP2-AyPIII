package edu.fiuba.algo3.controlador.Computadora;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;

public class DetallesControlador {
    private final Juego juego;
    private final Mision mision;

    public DetallesControlador(Juego juego, Mision mision) {
        this.juego = juego;
        this.mision = mision;
    }

    public DetalleControlador crearDetalleControlador(String tipo, Mision mision) {
        return new DetalleControlador(tipo, mision);
    }
}
