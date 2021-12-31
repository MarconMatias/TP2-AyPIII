package edu.fiuba.algo3.modelo.Calendario.Acciones;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
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
    public void avanzarCalendario(Calendario calendario) {
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
