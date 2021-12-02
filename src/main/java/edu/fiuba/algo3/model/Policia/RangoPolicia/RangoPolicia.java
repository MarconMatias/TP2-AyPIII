package edu.fiuba.algo3.model.Policia.RangoPolicia;

import edu.fiuba.algo3.model.Pista.IPista;
import edu.fiuba.algo3.model.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public abstract class RangoPolicia {

    private NivelPista nivelPista;

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        return nivelPista.filtrarPistas(pistas);
    };
}
