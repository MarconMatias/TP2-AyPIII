package edu.fiuba.algo3.model.Pista;

import edu.fiuba.algo3.model.Ciudad.Ciudad;
import edu.fiuba.algo3.model.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public class PistaCiudad implements IPista {


    private final String nivel;

    public PistaCiudad(String nivel){

        this.nivel = nivel;
    }

    public void agregarAListaSiEsNivel(ArrayList<IPista> pistas, String nivel){
        if(nivel.equals(this.nivel))
            pistas.add(this);
    }
}
