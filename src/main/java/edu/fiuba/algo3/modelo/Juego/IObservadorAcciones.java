package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Calendario.Acciones.IAccion;

public interface IObservadorAcciones {
    void accionRealizada(IAccion accion);
}
