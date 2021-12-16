package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;

public class AccionDormir implements IAccion {
    @Override
    public String getNombreAccion() {
        return "Durmiendo";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) {
        calendario.avanzarHoras(8);
    }
}
