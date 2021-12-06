package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroEconomia;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.Collection;
import java.util.List;

public class Bolsa extends EdificioAbstracto {
    public Bolsa()
    {
        super(new FiltroEconomia());
    }

    @Override
    protected String getNombreTestigo() {
        return "Corredor de bolsa";
    }

    @Override
    public String getNombreTipo() {
        return "Bolsa";
    }

}
