package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;

public interface IEstadoCuchilladas {
    void avanzarHoras(Calendario calendario) throws AccionException, CalendarioException;
    IEstadoCuchilladas siguienteEstado();
}
