package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IComportamientoAccion {
    void reaccion(Calendario calendario, Policia policia);
}
