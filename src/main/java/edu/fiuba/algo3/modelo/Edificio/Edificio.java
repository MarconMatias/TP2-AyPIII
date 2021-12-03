package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class Edificio {

    private final String nombreEdificio;
    private boolean existePista;

    public Edificio(String nombreEdificio, boolean existePista) {
        this.nombreEdificio = nombreEdificio;
        this.existePista = existePista;
    }

    public boolean mostrarPistaSiExiste(Ladron unLadron) {

        if( this.existePista ){

            System.out.println("Dentro del " + this.nombreEdificio + " encontre una pista, un sujeto dijo que el ladron llevaba un " + unLadron.mostrarSeña());
            return true;
        }
        else
            return false;

    }
}
