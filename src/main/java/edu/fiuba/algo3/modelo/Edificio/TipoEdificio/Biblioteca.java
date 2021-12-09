package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Pista.Filtro.*;

public class Biblioteca extends EdificioAbstracto {
    public Biblioteca()
    {
        super(new SinFiltro());
    }

    @Override
    public String getNombreTipo() {
        return "Biblioteca";
    }

    @Override
    protected String getNombreTestigo() {
        return "Bibliotecario";
    }

}
