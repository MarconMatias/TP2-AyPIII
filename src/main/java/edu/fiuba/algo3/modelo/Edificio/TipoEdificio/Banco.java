package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Pista.Filtro.*;

public class Banco extends EdificioAbstracto {
    private final IFiltroCiudad filtro = new FiltroEconomia();

    public Banco()
    {
        super(new FiltroEconomia());
    }

    @Override
    public String getNombreTipo() {
        return "Banco";
    }

    @Override
    protected String getNombreTestigo() {
        return "Banquero";
    }
}
