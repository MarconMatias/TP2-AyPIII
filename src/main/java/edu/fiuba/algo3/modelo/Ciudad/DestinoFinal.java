package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaTodoNivel;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class DestinoFinal implements IDestino {
    private final static String pista = "Ten cuidado, están sucediendo cosas raras.";
    @Override
    public IPista pistaAlAzar(Policia policia, IFiltroCiudad filtroCiudad) {
        return new PistaCiudad("Final", pista, new PistaTodoNivel());
    }
}
