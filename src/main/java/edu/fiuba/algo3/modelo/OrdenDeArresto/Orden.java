package edu.fiuba.algo3.modelo.OrdenDeArresto;

import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class Orden {
    private final ISospechoso posibleLadron;

    public Orden(ISospechoso sospechoso) {
        this.posibleLadron = sospechoso;
    }

    public boolean esElLadron(Ladron unLadron){

        return unLadron.equals(posibleLadron);
    }
}
