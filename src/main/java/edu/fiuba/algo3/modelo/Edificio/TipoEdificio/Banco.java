package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroEconomia;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.Collection;
import java.util.List;

public class Banco extends EdificioAbstracto {
    private final IFiltroCiudad filtro = new FiltroEconomia();
    @Override
    public String getNombreTipo() {
        return "Banco";
    }

    public Banco()
    {
        super(new FiltroEconomia());
    }

    @Override
    protected String getNombreTestigo() {
        return "Banquero";
    }
}
