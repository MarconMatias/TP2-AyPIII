package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;

public interface ITipoEdificio extends IFiltroCiudad {
    public String getNombreTipo();
    Testigo getTestigo();
}
