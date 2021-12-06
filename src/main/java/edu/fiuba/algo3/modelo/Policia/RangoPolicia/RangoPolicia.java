package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public class RangoPolicia {

    private IComportamientoRango comportamientoRango;
    private NivelPista nivelPista;

    public RangoPolicia(){

        this.comportamientoRango = (IComportamientoRango) new ComoNovato();
    }

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        return nivelPista.filtrarPistas(pistas);
    };

    public void ascender(){
        this.comportamientoRango.ascender();
    }
}
