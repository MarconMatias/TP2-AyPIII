package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IAccion {
    public String getNombreAccion();

    void avanzarCalendario(Calendario calendario);

    void setPolicia(Policia policia);

    void realizar();
}
