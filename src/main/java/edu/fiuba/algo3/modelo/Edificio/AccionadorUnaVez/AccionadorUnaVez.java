package edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez;

import edu.fiuba.algo3.modelo.Calendario.Acciones.AccionException;
import edu.fiuba.algo3.modelo.Calendario.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.IAccionador;
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
    public void visitar(Edificio edificio, Policia policia) throws AccionException {
        try {
            estado.visitar(edificio, policia);
            estado = estado.siguiente();
        } catch (AccionException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new AccionException("La acción no pudo realizarse al visitar un edificio.\n"+ex);
        }
    }
}
