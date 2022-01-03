package edu.fiuba.algo3.modelo.Calendario.Evento;

import edu.fiuba.algo3.modelo.Policia.Policia;

public class PoliciaPierde extends PoliciaFinaliza {
    /**
     * Un evento (Event) indicando que un policía perdió un enfrentamiento.
     *
     * @param policia El policía que perdió un enfrentamiento.
     * @throws IllegalArgumentException si policia es null
     * @param explicacion El texto que acompaña al evento, explicando por qué ganó.
     */
    public PoliciaPierde(Policia policia, String explicacion) {
        super(policia, explicacion);
    }
    @Override
    public boolean fueVictoria() {
        return false;
    }
}
