package edu.fiuba.algo3.controlador.Ciudad.Mapa;

import edu.fiuba.algo3.controlador.ControlStage;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Ciudad.DestinoCiudad;

public class MapaDestinosControlador extends PantallaControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;

    public MapaDestinosControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego, mision, controlStage);
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public void destinoElegido(DestinoCiudad destino) {
        System.out.println("Viajando a "+destino.getNombre());
        mision.viajarACiudad(destino.getCiudad());
        if(controlStage.abrirLibroCiudad()) {
            liberar();
        }
    }

}
