package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.Filtro.*;
import edu.fiuba.algo3.modelo.Policia.Policia;

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
