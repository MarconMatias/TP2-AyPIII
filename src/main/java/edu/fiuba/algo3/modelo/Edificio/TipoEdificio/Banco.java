package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Pista.Filtro.*;

public class Banco extends EdificioAbstracto {
    private final IFiltroCiudad filtro = new FiltroEconomia();
    private String nombre;

    public Banco()
    {

        super(new FiltroEconomia());
        this.nombre = nombreBanco;
    }

    @Override
    public String getNombreTipo() {
        return this.nombre ;
    }

    @Override
    protected String getNombreTestigo() {
        return "Banquero";
    }
}
