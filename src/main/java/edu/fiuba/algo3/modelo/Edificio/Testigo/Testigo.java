package edu.fiuba.algo3.modelo.Edificio.Testigo;

import edu.fiuba.algo3.modelo.Ciudad.*;
import edu.fiuba.algo3.modelo.Ladron.*;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Testigo {
    private final String nombre;
    private final IFiltroCiudad filtroCiudad;
    private ISospechoso sospechoso = new SinSospechoso();
    private IDestino destino = new SinDestino();
    private String testimonio;

    public Testigo(String nombre, IFiltroCiudad filtroCiudad)
    {
        this.nombre = nombre;
        this.filtroCiudad = filtroCiudad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getTestimonio(Policia policia)
    {
        if(null == testimonio) {
            testimonio = sospechoso.testimonioAlAzar(policia, destino, filtroCiudad);
        }
        return testimonio;
    }

    public void setTestimonio(ISospechoso sospechoso, IDestino destino)
    {
        this.sospechoso = sospechoso;
        this.destino = destino;
        this.testimonio = null;
    }

}
