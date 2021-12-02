package edu.fiuba.algo3.model.Pista;

import java.util.ArrayList;

public class PistaLadron implements IPista {

    private final String nivel;

    public PistaLadron(String nivel){
        this.nivel = nivel;
    }

    public void agregarAListaSiEsNivel(ArrayList<IPista> pistas, String nivel){
        if(nivel.equals(this.nivel))
            pistas.add(this);
    }
}
