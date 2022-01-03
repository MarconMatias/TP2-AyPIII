package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;

public class UnaChuchillada implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) throws PoliciaException {
        calendario.avanzarHoras(1);
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return this;
    }
}
