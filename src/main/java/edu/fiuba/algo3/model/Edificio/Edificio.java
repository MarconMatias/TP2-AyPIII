package edu.fiuba.algo3.model.Edificio;

import edu.fiuba.algo3.model.Item.Item;
import edu.fiuba.algo3.model.Ladron.Ladron;

public class Edificio {

    private final String nombreEdificio;
    private boolean existePista;

    public Edificio(String nombreEdificio, boolean existePista) {
        this.nombreEdificio = nombreEdificio;
        this.existePista = existePista;
    }

    public boolean mostrarPistaSiExiste(Ladron unLadron) {

        if( this.existePista ){

            System.out.println("Dentro del ",this.nombreEdificio, "encontre un ", unLadron.);
            return true;
        }
        else
            return false;

    }
}
