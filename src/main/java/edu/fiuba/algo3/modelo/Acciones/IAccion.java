package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;

public interface IAccion {
    public String getNombreAccion();

    void avanzarCalendario(Calendario calendario);
}
