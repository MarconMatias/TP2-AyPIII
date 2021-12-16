package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Ciudad.IDestino;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaFacil;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class SinDestino implements IDestino {
    @Override
    public IPista pistaAlAzar(Policia policia, IFiltroCiudad filtroCiudad) {
        return new PistaCiudad("Sin pista","", new PistaFacil());
    }
}
