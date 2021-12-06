package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.ArrayList;
import java.util.Collection;

public class RangoPolicia {

    private IComportamientoRango comportamientoRango;
    private NivelPista nivelPista;

    public RangoPolicia(){

        this.comportamientoRango = (IComportamientoRango) new ComoNovato();
    }

    public ArrayList<IPista> filtrarPistas(Collection<PistaCiudad> pistas){

        return nivelPista.filtrarPistas(pistas);
    };

    public void ascender(){
        this.comportamientoRango.ascender();
    }
}
