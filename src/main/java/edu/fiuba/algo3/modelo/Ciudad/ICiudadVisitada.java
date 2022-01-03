package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;

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
    String visitar(Edificio edificio) throws AccionException, CalendarioException, PoliciaException;
}
