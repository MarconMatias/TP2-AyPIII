package edu.fiuba.algo3.model.Pista.NivelPista;

import edu.fiuba.algo3.model.Pista.IPista;

import java.util.ArrayList;
import java.util.Random;

public abstract class NivelPista {

    private final String nivel;

    public NivelPista(String nivel) {
        this.nivel = nivel;
    }

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        ArrayList<IPista> pistasFiltradas = new ArrayList<IPista>();
        for (IPista p: pistas){

            p.agregarAListaSiEsNivel(pistasFiltradas,this.nivel);
        }

        Random numeroRandom = new Random();
        int indiceRandom = numeroRandom.nextInt(pistasFiltradas.size());
        return pistasFiltradas.get((indiceRandom));
    }
}
