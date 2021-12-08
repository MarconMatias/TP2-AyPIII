package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import java.util.Collection;
import java.util.List;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;


public class Aeropuerto extends EdificioAbstracto{

    private final String nombre;

    public Aeropuerto(String nombreAeropuerto) {
        this.nombre = nombreAeropuerto;
    }

    @Override
    public String getNombreTipo() {
        return nombre;
    }

    @Override
    public Testigo getTestigo() {
        return null;
    }

    @Override
    protected String getNombreTestigo() {
        return null;
    }

    @Override
    public boolean mostrarPista(Ladron unLadron) {
        return false;
    }

    @Override
    public void visitadoPorLadron(Ladron ladron, Ciudad destino) {

    }

    @Override
    public void visitar(Policia policia, Calendario cal) {

    }

    @Override
    public List<PistaCiudad> filtrarPistas(Collection<PistaCiudad> sinFiltrar) {
        return null;
    }
}

