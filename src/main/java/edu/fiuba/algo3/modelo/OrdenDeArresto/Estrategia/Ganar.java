package edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Ganar implements IEstrategiaOrden {
    @Override
    public void realizar(Policia policia, Ladron ladron) {
        policia.agregarArresto();
        policia.ganar("¡Arrestaste a "+ladron.getNombre()+"!");
    }
}
