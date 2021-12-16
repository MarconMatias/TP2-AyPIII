package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Juego.Calendario;

public class UnaChuchillada implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) {
        calendario.avanzarHoras(1);
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return this;
    }
}
