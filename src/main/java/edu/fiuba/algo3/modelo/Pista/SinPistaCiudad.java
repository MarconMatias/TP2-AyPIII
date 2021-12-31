package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import java.util.ArrayList;

public class SinPistaCiudad implements IPista {
    @Override
    public void agregarAListaSiEsNivel(ArrayList<IPista> pistas, NivelPista nivel) {
        pistas.add(this);
    }

    @Override
    public boolean conDificultad(Object pista) {
        return false;
    }

    @Override
    public String toString() {
        return "No sabría darte ningún dato útil.";
    }
}
