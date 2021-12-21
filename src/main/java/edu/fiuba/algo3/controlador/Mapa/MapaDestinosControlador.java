package edu.fiuba.algo3.controlador.Mapa;

import edu.fiuba.algo3.ControladorStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;

public class MapaDestinosControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControladorStage controladorStage;

    public MapaDestinosControlador(Juego juego, Mision mision, ControladorStage controladorStage) {
        this.juego = juego;
        this.mision = mision;
        this.controladorStage = controladorStage;
    }
}
