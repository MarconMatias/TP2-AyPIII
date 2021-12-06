package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class Visitado implements IComportamientoEdificio {

    public Visitado(){

    }

    @Override
    public IComportamientoEdificio lanzarEvento(Ladron unLadron) {
        
        return this;
    }
}
