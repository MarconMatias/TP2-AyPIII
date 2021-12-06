package edu.fiuba.algo3.model.Policia.RangoPolicia;

import edu.fiuba.algo3.model.Pista.IPista;
import edu.fiuba.algo3.model.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public abstract class RangoPolicia {

    private String nombreRango;

    private NivelPista nivelPista;

    public  RangoPolicia(String nombreRango){

        this.nombreRango = nombreRango;
    }

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        return nivelPista.filtrarPistas(pistas);
    };
}
