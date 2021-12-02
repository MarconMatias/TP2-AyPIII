package edu.fiuba.algo3.model.Pista.NivelPista;

import edu.fiuba.algo3.model.Pista.IPista;

import java.util.ArrayList;

public abstract class NivelPista {

    private final String nivel;

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        ArrayList<IPista> pistasFiltradas = new ArrayList<IPista>();
        for (IPista p: pistas){

            p.agregarAListaSiEsNivel(pistasFiltradas,nivel);
        }
    }
}
