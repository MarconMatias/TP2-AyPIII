package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public abstract class RangoPolicia {

    private final String nombreRango;

    private NivelPista nivelPista;

    public RangoPolicia(String nombreRango){

        this.nombreRango = nombreRango;
    }

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        return nivelPista.filtrarPistas(pistas);
    };
}
