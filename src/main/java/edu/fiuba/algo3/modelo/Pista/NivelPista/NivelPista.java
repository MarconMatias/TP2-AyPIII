package edu.fiuba.algo3.modelo.Pista.NivelPista;

import edu.fiuba.algo3.modelo.Pista.IPista;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class NivelPista {

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        ArrayList<IPista> pistasFiltradas = new ArrayList<IPista>();
        for (IPista p: pistas) {
            p.agregarAListaSiEsNivel(pistasFiltradas,this);
        }

        Random numeroRandom = new Random();
        int indiceRandom = numeroRandom.nextInt(pistasFiltradas.size());
        return pistasFiltradas.get((indiceRandom));
    }

    public abstract boolean esEquivalente(NivelPista nivel);
}
