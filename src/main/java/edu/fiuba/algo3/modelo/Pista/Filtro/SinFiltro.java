package edu.fiuba.algo3.modelo.Pista.Filtro;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SinFiltro implements IFiltroCiudad {

    @Override
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar) {
        return sinFiltrar.stream().collect(Collectors.toList());
    }
}
