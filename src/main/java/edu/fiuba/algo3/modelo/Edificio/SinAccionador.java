package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class SinComportamiento implements IAccionador {
    @Override
    public IAccionador lanzarEvento(Ladron unLadron) {
        return null;
    }

    @Override
    public void visitar(ITipoEdificio edificio, Policia policia) {
        // No tiene que hacer nada
    }
}
