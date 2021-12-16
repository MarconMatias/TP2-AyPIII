package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class SinAccionador implements IAccionador {
    @Override
    public IAccionador lanzarEvento(Ladron unLadron) {
        return null;
    }

    @Override
    public void visitar(Edificio edificio, Policia policia) {
        // No tiene que hacer nada
    }
}
