package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class Edificio {

    private final String nombreEdificio;
    private IComportamientoEdificio comportamientoEdificio;

    public Edificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
        this.comportamientoEdificio = new NoVisitado();
    }

    public boolean generarEvento(Ladron unLadron) {

        this.comportamientoEdificio = this.comportamientoEdificio.lanzarEvento( unLadron );
        return true;
    }
}
