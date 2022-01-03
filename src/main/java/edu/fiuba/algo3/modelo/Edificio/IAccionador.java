package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Calendario.Acciones.AccionException;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IAccionador {
    void visitar(Edificio edificio, Policia policia) throws AccionException;
}
