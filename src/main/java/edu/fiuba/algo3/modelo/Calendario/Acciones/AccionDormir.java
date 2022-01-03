package edu.fiuba.algo3.modelo.Calendario.Acciones;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class AccionDormir implements IAccion {
    @Override
    public String getNombreAccion() {
        return "Dormir";
    }

    @Override
    public String getTextoAccion()
    {
        return "Estás durmiendo…";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) throws PoliciaException {
        try {
            calendario.avanzarHoras(8);
        } catch (CalendarioException e) {
            throw new PoliciaException("Error. El policia no pudo avanzar las horas: " + e.getMessage());
        }
    }

    @Override
    public void setPolicia(Policia policia) {
        /** No debe hacer nada. **/
    }

    @Override
    public void realizar() {
        /** No debe hacer nada. **/
    }
}
