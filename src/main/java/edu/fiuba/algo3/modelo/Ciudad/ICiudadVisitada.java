package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Edificio.Edificio;

import java.util.List;

public interface ICiudadVisitada {
    List<Edificio> obtenerEdificios();
    void visitarEdificio(Edificio edificio);
}
