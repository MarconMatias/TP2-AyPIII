package edu.fiuba.algo3.modelo.OrdenDeArresto;

import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia.Ganar;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia.IEstrategiaOrden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Estrategia.Perder;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Orden implements IOrden {
    private final Ladron sospechoso;
    private IEstrategiaOrden estrategia;

    public Orden(Ladron sospechoso) {
        this.sospechoso = sospechoso;
    }

    public boolean esElLadron(Ladron otroLadron){

        return sospechoso.equals(otroLadron);
    }

    @Override
    public void enfrentar(Policia policia, Ladron ladron) {
        if(esElLadron(ladron)) {
            estrategia = new Ganar();
        } else {
            estrategia = new Perder("La orden de arresto era otra persona, no pudiste ");
        }
        estrategia.realizar(policia, ladron);
    }
}
