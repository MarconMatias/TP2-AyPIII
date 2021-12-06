package edu.fiuba.algo3.modelo.Pista.NivelPista;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public abstract class NivelPista {

    public ArrayList<IPista> filtrarPistas(Collection<PistaCiudad> pistas) {

        ArrayList<IPista> pistasFiltradas = new ArrayList<IPista>();
        for (IPista p : pistas) {
            p.agregarAListaSiEsNivel(pistasFiltradas,this);
        }
        return pistasFiltradas;
   }

    public abstract boolean esEquivalente(NivelPista nivel);
}
