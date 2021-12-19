package edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez;

import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class AccionadorUnaVez implements IAccionador {
    private final IAccion accion;
    protected IEstadoVisitado estado;
    public AccionadorUnaVez(IAccion accion)
    {
        this.accion = accion;
        estado = new NoVisitado(accion);
    }

    @Override
    public IAccionador lanzarEvento(Ladron unLadron) {
        return null;
    }

    @Override
    public void visitar(Edificio edificio, Policia policia) {
        estado.visitar(edificio, policia);
        estado = estado.siguiente();
    }
}
