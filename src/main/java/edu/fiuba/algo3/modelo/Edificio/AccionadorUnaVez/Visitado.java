package edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Visitado implements IEstadoVisitado {
    @Override
    public void visitar(Edificio edificio, Policia policia) {
        // Ya fue visitado, no debe hacer nada.
    }

    @Override
    public IEstadoVisitado siguiente() {
        return this;
    }
}
