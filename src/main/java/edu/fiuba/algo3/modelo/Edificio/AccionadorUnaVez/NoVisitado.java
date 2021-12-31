package edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez;

import edu.fiuba.algo3.modelo.Calendario.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class NoVisitado implements IEstadoVisitado {

    private final IAccion accion;

    public NoVisitado(IAccion accion)
    {
        this.accion = accion;
    }

    @Override
    public void visitar(Edificio edificio, Policia policia) {
        policia.realizarAccion(accion);
    }

    @Override
    public IEstadoVisitado siguiente() {
        return new Visitado();
    }
}
