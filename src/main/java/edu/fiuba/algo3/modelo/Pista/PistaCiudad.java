package edu.fiuba.algo3.modelo.Pista;

import java.util.ArrayList;

public class PistaCiudad implements IPista {

    private final String tipo;
    private final String pista;
    // private final NivelPista nivel;

    // private NivelPista nivel;

    public PistaCiudad(String tipo, String pista, int dificultad) {

        this.tipo = tipo;
        this.pista = pista;
        // this.nivel = definirNivel(dificultad);
    }

    private void definirNivel(int dificultad) {
        // return nivel.definirNivel(dificultad);
    }
}
