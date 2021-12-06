package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.Filtro.SinFiltro;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.Collection;
import java.util.List;

public abstract class EdificioAbstracto implements ITipoEdificio {
    protected final IFiltroCiudad filtro;

    public EdificioAbstracto()
    {
        this.filtro = new SinFiltro();
    }

    public EdificioAbstracto(IFiltroCiudad filtro)
    {
        this.filtro = filtro;
    }

    @Override
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar) {
        return filtro.filtrarPistas(sinFiltrar);
    }

    @Override
    public Testigo getTestigo() {
        return new Testigo(getNombreTestigo(),filtro);
    }

    protected abstract String getNombreTestigo();
}