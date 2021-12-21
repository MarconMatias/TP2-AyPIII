package edu.fiuba.algo3.vista.Mapa;

import edu.fiuba.algo3.componentes.Mapamundi.Mapamundi;
import edu.fiuba.algo3.controlador.Mapa.MapaDestinosControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;

public class MapaDestinos extends Mapamundi {
    private final Juego juego;
    private final Mision mision;
    private final MapaDestinosControlador controlador;

    public MapaDestinos(Juego juego, Mision mision, MapaDestinosControlador controlador)
    {
        super();
        this.juego = juego;
        this.mision = mision;
        this.controlador = controlador;
        //setRadio(juego.getRadio());
    }
}
