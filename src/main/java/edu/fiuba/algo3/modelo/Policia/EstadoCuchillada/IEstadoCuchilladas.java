package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;

public interface IEstadoCuchilladas {
    void avanzarHoras(Calendario calendario) throws PoliciaException;
    IEstadoCuchilladas siguienteEstado();
}
