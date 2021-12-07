
package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class SinComportamiento implements IComportamientoEdificio {
    @Override
    public IComportamientoEdificio lanzarEvento(Ladron unLadron) {
        return null;
    }

    @Override
    public void visitar(ITipoEdificio edificio, Policia policia, Calendario cal) {
        // No tiene que hacer nada
    }
}