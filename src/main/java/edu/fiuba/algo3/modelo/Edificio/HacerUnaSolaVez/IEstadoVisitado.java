package edu.fiuba.algo3.modelo.Edificio.HacerUnaSolaVez;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;


public interface IEstadoVisitado {
    public void visitar(ITipoEdificio edificio, Policia policia, Calendario cal);

    IEstadoVisitado siguiente();
}
