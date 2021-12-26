package edu.fiuba.algo3.modelo.OrdenDeArresto;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia.Perder;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class SinOrden implements IOrden {
    final static String explicacionFinal = "Como no tenías orden de arresto, tuviste que dejar que escape.";
    private final String motivoSinOrden;

    public SinOrden(String motivo) {
        motivoSinOrden = motivo;
    }

    @Override
    public void enfrentar(Policia policia, Ladron ladron) {
        String explicacion = "Te encontraste con "+ladron +". " + motivoSinOrden + explicacionFinal;
        Perder estrategiaOrden = new Perder(explicacion);
        estrategiaOrden.realizar(policia,ladron);
    }

    @Override
    public String getEmitidaPara() {
        return null;
    }

    @Override
    public int getHorasDemora() {
        return 0;
    }
}
