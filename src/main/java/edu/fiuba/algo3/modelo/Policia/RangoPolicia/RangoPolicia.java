package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.ArrayList;
import java.util.Collection;

public class RangoPolicia {

    private IComportamientoRango comportamientoRango;
    private NivelPista nivelPista;
    private Integer arrestos;

    public RangoPolicia(){

        this.comportamientoRango = (IComportamientoRango) new ComoNovato();

    }

    public ArrayList<IPista> filtrarPistas(ArrayList<IPista> pistas){

        return (ArrayList<IPista>) nivelPista.filtrarPistas(pistas);
    }

    public void actualizarArrestos(){

        this.arrestos = this.arrestos + 1;
        this.comportamientoRango = this.comportamientoRango.siguienteComportamientoConArrestos(this.arrestos);
    }
}
