package edu.fiuba.algo3.modelo.Calendario.Acciones;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IAccion {
    void avanzarCalendario(Calendario calendario) throws PoliciaException;

    String getNombreAccion();

    String getTextoAccion();

    void realizar() throws PoliciaException;

    void setPolicia(Policia policia);
}
