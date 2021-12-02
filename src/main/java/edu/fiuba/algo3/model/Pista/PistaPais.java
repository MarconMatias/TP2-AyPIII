package edu.fiuba.algo3.model.Pista;

import edu.fiuba.algo3.model.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public class PistaPais implements IPista {

    private final String ciudad;
    private final String bandera;
    private final String moneda;
    private final String terreno;
    private final String puntosDeInteres;
    private final String industria;
    private final String animales;
    private final String etnias;
    private final String lenguaje;
    private final String arte;
    private final String religion;
    private final String gobernante;
    private final String origen;

    public PistaPais(String ciudad, String bandera, String moneda, String terreno, String puntosDeInteres, String industria, String animales, String etnias, String lenguaje, String arte, String religion, String gobernante, String origen) {

        this.ciudad = ciudad;
        this.bandera = bandera;
        this.moneda = moneda;
        this.terreno = terreno;
        this.puntosDeInteres = puntosDeInteres;
        this.industria = industria;
        this.animales = animales;
        this.etnias = etnias;
        this.lenguaje = lenguaje;
        this.arte = arte;
        this.religion = religion;
        this.gobernante = gobernante;
        this.origen = origen;
    }

    public boolean esLaCiudad(String ciudad) {
        return this.ciudad.equals(ciudad);
    }

    public IPista agregarAListaSiEsNivel(ArrayList<IPista> pistas, NivelPista nivel){

    }
}
