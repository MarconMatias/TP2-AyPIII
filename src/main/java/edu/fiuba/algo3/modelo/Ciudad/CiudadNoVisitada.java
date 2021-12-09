package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Edificio.Edificio;

import java.util.List;

public class CiudadNoVisitada implements ICiudadVisitada {
    @Override
    public List<Edificio> obtenerEdificios() {
        throw new RuntimeException("La ciudad no está visitada, no tiene edificios disponibles.");
    }

    @Override
    public void visitarEdificio(Edificio edificio) {
        throw new RuntimeException("La ciudad no está visitada, no tiene edificios disponibles.");
    }
}
