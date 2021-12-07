package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroEconomia;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

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

<<<<<<< HEAD
}
=======
    @Override
    public boolean mostrarPista(Ladron unLadron) {
        return true;
    }

    @Override
    public void visitadoPorLadron(Ladron ladron, Ciudad destino) {

    }

    @Override
    public void visitar(Policia policia, Calendario cal) {
    }

}
>>>>>>> 98e67cf7bebb438f2023ea83de30f8ebb1031c8f
