package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;

public class UnaChuchillada implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) throws PoliciaException {
        try {
            calendario.avanzarHoras(1);
        } catch (CalendarioException e) {
            throw new PoliciaException("Error. El policia no pudo avanzar la hora: " + e.getMessage());
        }
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return this;
    }
}
