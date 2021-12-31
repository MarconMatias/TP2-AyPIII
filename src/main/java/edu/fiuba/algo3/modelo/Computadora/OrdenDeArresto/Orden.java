package edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.Estrategia.Ganar;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.Estrategia.IEstrategiaOrden;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.Estrategia.Perder;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Orden implements IOrden {
    private final Ladron sospechoso;
    private IEstrategiaOrden estrategia;

    public Orden(Ladron sospechoso) {
        this.sospechoso = sospechoso;
    }

    private boolean esElLadron(Ladron otroLadron){

        return sospechoso.equals(otroLadron);
    }

    @Override
    public void enfrentar(Policia policia, Ladron ladron) {

        if(ladron == null)
            throw new IllegalArgumentException("Error. El Ladron pasado por parametro no es valido");

        if(esElLadron(ladron)) {
            estrategia = new Ganar();
        } else {
            String explicacion = "La orden de arresto era para "+sospechoso+", pero encontraste a "+ladron+"; tuviste que dejar que escape.";
            estrategia = new Perder(explicacion);
        }
        estrategia.realizar(policia, ladron);
    }

    @Override
    public String getEmitidaPara() {
        return sospechoso.getNombre();
    }

    @Override
    public int getHorasDemora() {
        return 3;
    }
}
