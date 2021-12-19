package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Policia.Policia;

public class PoliciaGana extends PoliciaFinaliza {
    /**
     * Un evento (Event) indicando que un policía ganó un enfrentamiento.
     *
     * @param policia El policía que ganó.
     * @throws IllegalArgumentException si policia es null
     * @param explicacion El texto que acompaña al evento, explicando por qué ganó.
     */
    public PoliciaGana(Policia policia, String explicacion) {
        super(policia, explicacion);
    }
    @Override
    public boolean fueVictoria() {
        return true;
    }
}
