package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IDestino {
    IPista pistaAlAzar(Policia policia, IFiltroCiudad filtroCiudad);
}
