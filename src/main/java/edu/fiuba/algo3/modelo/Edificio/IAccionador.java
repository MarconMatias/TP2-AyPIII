package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IAccionador {

    IAccionador lanzarEvento(Ladron unLadron);
    void visitar(Edificio edificio, Policia policia);
}
