package edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Policia.Policia;


public interface IEstadoVisitado {
    public void visitar(Edificio edificio, Policia policia);

    IEstadoVisitado siguiente();
}
