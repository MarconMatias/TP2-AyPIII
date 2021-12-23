package edu.fiuba.algo3.modelo.OrdenDeArresto;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IOrden {
    public void enfrentar(Policia policia, Ladron ladron);

    String getEmitidaPara();
}
