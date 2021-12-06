package edu.fiuba.algo3.modelo.Ciudad;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

public class Ciudad {

    private final String nombre;
    private final ArrayList<PistaCiudad> pistas;

    private int cantidadDeVisitas = 0;

    public Ciudad(String nombre, ArrayList<PistaCiudad> pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
    }

    public void visitar() {
        //
    }

    public boolean esLaCiudad(String nombre) {
        return this.nombre.equals(nombre);
    }
}
