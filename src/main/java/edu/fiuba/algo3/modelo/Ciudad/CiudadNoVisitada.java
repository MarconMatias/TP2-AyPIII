package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Edificio.Edificio;

import java.util.Collections;
import java.util.List;

public class CiudadNoVisitada implements ICiudadVisitada {
    final String advertencia = "La ciudad no está visitada, no tiene edificios disponibles.";
    @Override
    public List<Edificio> obtenerEdificios() {
        System.err.println(advertencia);
        return Collections.emptyList();
    }

    @Override
    public String visitar(Edificio edificio) {
        System.err.println(advertencia);
        return "No estás acá, no puedo darte pistas.";
    }
}
