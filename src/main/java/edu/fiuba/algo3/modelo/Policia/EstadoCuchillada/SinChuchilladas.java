package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.EstadoCuchillada.IEstadoCuchilladas;

public class SinChuchilladas implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) {
        calendario.avanzarHoras(2);
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return new UnaChuchillada();
    }
}
