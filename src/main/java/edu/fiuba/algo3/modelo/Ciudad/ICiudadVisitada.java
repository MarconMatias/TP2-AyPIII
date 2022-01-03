package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Calendario.Acciones.AccionException;
import edu.fiuba.algo3.modelo.Edificio.Edificio;

import java.util.List;

public interface ICiudadVisitada {
    List<Edificio> obtenerEdificios();
    /**
     * El policía que está visitando esta ciudad, vista al edificio dado.
     * * Avanza el calendario por la visita misma.
     * * Puede disparar acciones que avancen a su vez el calendario.
     * @param edificio Un edificio de la ciudad actual.
     * @return El testimonio obtenido en el edificio de la ciudad actual.
     */
    String visitar(Edificio edificio) throws AccionException;
}
