package edu.fiuba.algo3.modelo.Pista.Filtro;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface IFiltroCiudad {
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar);
}
