package edu.fiuba.algo3.modelo.OrdenDeArresto;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia.IEstrategiaOrden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia.Perder;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class SinOrden implements IOrden {
    final static String explicacion = "Como no tenías orden de arresto, tuviste que dejar que escape.";
    IEstrategiaOrden estrategiaOrden = new Perder(explicacion);
    @Override
    public void enfrentar(Policia policia, Ladron ladron) {
        estrategiaOrden.realizar(policia,ladron);
    }
}
