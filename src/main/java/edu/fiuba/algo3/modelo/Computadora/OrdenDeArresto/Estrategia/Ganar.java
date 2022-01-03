package edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.Estrategia;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Ganar implements IEstrategiaOrden {
    @Override
    public void realizar(Policia policia, Ladron ladron) {

        if(ladron == null || policia == null)
            throw new IllegalArgumentException("El Policia o el Ladron pasado por parámetro no es válido.");
        policia.agregarArresto();
        policia.ganar("¡Arrestaste a "+ladron.getNombre()+"!");
    }
}
