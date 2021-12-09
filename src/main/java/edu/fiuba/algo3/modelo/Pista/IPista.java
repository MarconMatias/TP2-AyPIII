package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public interface IPista {
    public void agregarAListaSiEsNivel(ArrayList<IPista> pistas, NivelPista nivel);
}
