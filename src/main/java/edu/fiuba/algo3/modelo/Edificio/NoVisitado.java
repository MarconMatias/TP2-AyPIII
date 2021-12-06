package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class NoVisitado implements IComportamientoEdificio{


    public NoVisitado(){

    }

    @Override
    public IComportamientoEdificio lanzarEvento(Ladron unLadron){

        unLadron.mostrarSeña();
        return new Visitado();
    }
}
