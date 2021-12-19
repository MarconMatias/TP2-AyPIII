package edu.fiuba.algo3.modelo.Evento;

import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.EventObject;

public abstract class PoliciaFinaliza extends EventObject {
    private final String explicacion;

    /**
     * @param policia El policía que finaliza un enfrentamiento.
     * @throws IllegalArgumentException si policia es null
     * @param explicacion El texto que acompaña al evento, explicando por qué ganó.
     */
    public PoliciaFinaliza(Policia policia, String explicacion) {
        super(policia);
        this.explicacion = explicacion;
    }
    public String getExplicacion() {
        return explicacion;
    }

    public abstract boolean fueVictoria();
}
