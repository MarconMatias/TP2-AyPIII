package edu.fiuba.algo3.modelo.Pista.Filtro;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroEconomia implements IFiltroCiudad {
    private static final ArrayList<String> tipos = new ArrayList<>(List.of(
            "Moneda","Exportaciones"
    ));

    @Override
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar) {
        return sinFiltrar.stream().filter(pista -> pista.esDeUnTipoDe(tipos))
                .collect(Collectors.toList());
    }
}
