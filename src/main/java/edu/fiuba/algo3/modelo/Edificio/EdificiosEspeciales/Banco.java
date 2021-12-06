package edu.fiuba.algo3.modelo.Edificio.EdificiosEspeciales;

import edu.fiuba.algo3.modelo.Edificio.IComportamientoEdificio;
import edu.fiuba.algo3.modelo.Edificio.ComportamientosEdificios.NoVisitado;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class Banco {

    private final String nombreEdificio;
    private IComportamientoEdificio comportamientoEdificio;

    public Banco(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
        this.comportamientoEdificio = new NoVisitado();
    }

    public boolean generarEvento(Ladron unLadron) {

        this.comportamientoEdificio = this.comportamientoEdificio.lanzarEvento( unLadron );
        return true;
    }
}
