package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;

public interface IEstadoCuchilladas {
    void avanzarHoras(Calendario calendario);
    IEstadoCuchilladas siguienteEstado();
}
