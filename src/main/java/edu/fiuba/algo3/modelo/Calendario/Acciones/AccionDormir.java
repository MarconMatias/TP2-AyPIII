package edu.fiuba.algo3.modelo.Calendario.Acciones;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
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
    public void avanzarCalendario(Calendario calendario) throws AccionException {
        try {
            calendario.avanzarHoras(8);
        } catch (CalendarioException ex) {
            throw new AccionException("No pudo avanzarse el calendario para dormir.\n" + ex.getMessage());
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
