package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.NoSePudoRealizarAccionException;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IAccion {
    public String getNombreAccion();

    void avanzarCalendario(Calendario calendario) throws CalendarioException, AccionException;

    void setPolicia(Policia policia);

    void realizar() throws NoSePudoRealizarAccionException, AccionException;
}
