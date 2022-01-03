package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;

public class SinChuchilladas implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) throws PoliciaException {
        try {
            calendario.avanzarHoras(2);
        } catch (CalendarioException e) {
            throw new PoliciaException("Error. El policia no pudo avanzar las horas: " + e.getMessage());
        }
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return new UnaChuchillada();
    }
}
