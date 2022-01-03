package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;

public class SinChuchilladas implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) throws PoliciaException {
        calendario.avanzarHoras(2);
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return new UnaChuchillada();
    }
}
