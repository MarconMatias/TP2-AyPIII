package edu.fiuba.algo3.modelo.Calendario.Acciones;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IAccion {
    void avanzarCalendario(Calendario calendario);

    String getNombreAccion();

    String getTextoAccion();

    void realizar();

    void setPolicia(Policia policia);
}
