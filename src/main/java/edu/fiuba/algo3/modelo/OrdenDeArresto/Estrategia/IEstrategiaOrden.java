package edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IEstrategiaOrden {
    void realizar(Policia policia, Ladron ladron);
}
