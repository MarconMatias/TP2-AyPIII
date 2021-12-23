package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Pista.Filtro.*;

public class Aeropuerto extends EdificioAbstracto{
    public Aeropuerto() {
        super(new FiltroPais());
    }

    @Override
    public String getNombreTipo() {
        return "Aeropuerto";
    }

    @Override
    protected String getNombreTestigo() {
        return "Piloto";
    }


}

