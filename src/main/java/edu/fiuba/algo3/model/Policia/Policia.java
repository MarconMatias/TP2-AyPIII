package edu.fiuba.algo3.model.Policia;

import edu.fiuba.algo3.model.Pista.IPista;
import edu.fiuba.algo3.model.Policia.RangoPolicia.RangoPolicia;

import java.util.ArrayList;

public class Policia {

    private RangoPolicia rango;

    public Policia(){

    }

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        return rango.filtrarPistas(pistas);

    }

}
