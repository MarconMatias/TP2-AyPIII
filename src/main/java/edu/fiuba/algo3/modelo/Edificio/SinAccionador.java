package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Calendario.Acciones.AccionException;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class SinAccionador implements IAccionador {
    @Override
    public void visitar(Edificio edificio, Policia policia) throws AccionException {
        // No tiene que hacer nada
    }
}
