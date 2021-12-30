package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class AccionDormir implements IAccion {
    @Override
    public String getNombreAccion() {
        return "Durmiendo";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) throws CalendarioException, AccionException {

        calendario.avanzarHoras(8);

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
