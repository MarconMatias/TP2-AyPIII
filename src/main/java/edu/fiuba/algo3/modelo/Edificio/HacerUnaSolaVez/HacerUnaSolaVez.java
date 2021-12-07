package edu.fiuba.algo3.modelo.Edificio.HacerUnaSolaVez;

import edu.fiuba.algo3.modelo.Edificio.IComportamientoEdificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class HacerUnaSolaVez implements IComportamientoEdificio {
    protected IEstadoVisitado estado = new NoVisitado();
    public HacerUnaSolaVez(/** Accion **/)
    {
    }

    @Override
    public IComportamientoEdificio lanzarEvento(Ladron unLadron) {
        return null;
    }

    @Override
    public void visitar(ITipoEdificio edificio, Policia policia, Calendario cal) {
        estado.visitar(edificio, policia, cal);
        estado = estado.siguiente();
    }
}
