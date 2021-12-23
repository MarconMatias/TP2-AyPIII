package edu.fiuba.algo3.modelo.Pista.Filtro;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPais implements IFiltroCiudad{
    private static final ArrayList<String> tipos = new ArrayList<>(List.of(
        "Bandera","Idioma","Puntos de Interes","Animales"
    ));

    @Override
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar) {
        List<PistaCiudad> filtrada = sinFiltrar.stream().filter(pista -> pista.esDeUnTipoDe(tipos))
                .collect(Collectors.toList());
        return filtrada;
    }
    
}
