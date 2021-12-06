package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public class PistaLadron implements IPista {

    private final NivelPista nivel;

    public PistaLadron(NivelPista nivel){
        this.nivel = nivel;
    }

    @Override
    public void agregarAListaSiEsNivel(ArrayList<IPista> pistas, NivelPista nivel) {
        if(this.nivel.esEquivalente(nivel))
        {
            pistas.add(this);
        }
    }
}
