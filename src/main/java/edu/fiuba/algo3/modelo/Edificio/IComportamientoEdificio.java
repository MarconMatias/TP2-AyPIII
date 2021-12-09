package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IComportamientoEdificio {

    IComportamientoEdificio lanzarEvento(Ladron unLadron);
    void visitar(ITipoEdificio edificio, Policia policia);
}
