package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;

public class UnaChuchillada implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) throws AccionException, CalendarioException {
        if(calendario == null)
            throw new IllegalArgumentException("Error. El Calendario pasado por parametro no es valido");
        calendario.avanzarHoras(1);
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return this;
    }
}
