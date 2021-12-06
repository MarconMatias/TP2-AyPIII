package edu.fiuba.algo3.modelo.Pista.NivelPista;

import edu.fiuba.algo3.modelo.Pista.IPista;

import java.util.ArrayList;
import java.util.Random;

public abstract class NivelPista {

    public IPista filtrarPistas(ArrayList<IPista> pistas) {

        ArrayList<IPista> pistasFiltradas = new ArrayList<IPista>();
        for (IPista p : pistas) {
            p.agregarAListaSiEsNivel(pistasFiltradas,this);
        }

        Random numeroRandom = new Random();
        int indiceRandom = numeroRandom.nextInt(pistasFiltradas.size());
        return pistasFiltradas.get((indiceRandom));
    }

    public abstract boolean esEquivalente(NivelPista nivel);
}
