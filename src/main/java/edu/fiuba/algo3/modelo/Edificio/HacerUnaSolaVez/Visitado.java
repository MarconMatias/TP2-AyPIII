package edu.fiuba.algo3.modelo.Edificio.HacerUnaSolaVez;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.IComportamientoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Visitado implements IEstadoVisitado {
    @Override
    public void visitar(Edificio edificio, Policia policia, Calendario cal) {
        // Ya fue visitado, no debe hacer nada.
    }

    @Override
    public IEstadoVisitado siguiente() {
        return this;
    }
}
