package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.Collection;
import java.util.List;

public class Aeropuerto implements ITipoEdificio{
    @Override
    public String getNombreTipo() {
        return null;
    }

    @Override
    public Testigo getTestigo() {
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
