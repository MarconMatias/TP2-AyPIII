package edu.fiuba.algo3.controlador.Ciudad;

import edu.fiuba.algo3.ControladorStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;

public class LibroCiudadControlador {
    private final Juego juego;
    private final ControladorStage controladorStage;
    private final Mision mision;

    public LibroCiudadControlador(Juego juego, Mision mision, ControladorStage controladorStage) {
        this.juego = juego;
        this.mision = mision;
        this.controladorStage = controladorStage;
    }
}
