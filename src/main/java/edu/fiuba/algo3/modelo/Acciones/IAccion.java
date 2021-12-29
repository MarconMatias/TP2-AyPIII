package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IAccion {
    void avanzarCalendario(Calendario calendario);

    String getNombreAccion();

    String getTextoAccion();

    void realizar();

    void setPolicia(Policia policia);
}
