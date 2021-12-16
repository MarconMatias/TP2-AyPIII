package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Juego.Calendario;

public interface IEstadoCuchilladas {
    void avanzarHoras(Calendario calendario);
    IEstadoCuchilladas siguienteEstado();
}
