package edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez;

import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class AccionadorSolaVez implements IAccionador {
    protected IEstadoVisitado estado = new NoVisitado();
    public AccionadorSolaVez(/** Accion **/)
    {
    }

    @Override
    public IAccionador lanzarEvento(Ladron unLadron) {
        return null;
    }

    @Override
    public void visitar(ITipoEdificio edificio, Policia policia) {
        estado.visitar(edificio, policia);
        estado = estado.siguiente();
    }
}
