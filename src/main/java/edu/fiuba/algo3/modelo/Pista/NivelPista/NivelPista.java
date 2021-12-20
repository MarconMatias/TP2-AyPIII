package edu.fiuba.algo3.modelo.Pista.NivelPista;

import edu.fiuba.algo3.modelo.Pista.IPista;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public abstract class NivelPista {

    private NivelPista nivel = null;

    public NivelPista() {
        this.nivel = nivel;
    }

    public Collection<IPista> filtrarPistas(Collection<IPista> pistas){

        ArrayList<IPista> pistasFiltradas = new ArrayList<IPista>();
        for (IPista p: pistas){

            p.agregarAListaSiEsNivel(pistasFiltradas,this.nivel);
        }
        return pistasFiltradas;
    }

    public abstract boolean esEquivalente(NivelPista nivel);
}
