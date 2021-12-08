package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroEconomia;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.Collection;
import java.util.List;

public class Banco extends EdificioAbstracto {
    private final IFiltroCiudad filtro = new FiltroEconomia();
    private String nombre;

    public Banco(String nombreBanco)
    {

        super(new FiltroEconomia());
        this.nombre = nombreBanco;
    }

    @Override
    public String getNombreTipo() {
        return this.nombre ;
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

    @Override
    protected String getNombreTestigo() {
        return "Banquero";
    }
}
