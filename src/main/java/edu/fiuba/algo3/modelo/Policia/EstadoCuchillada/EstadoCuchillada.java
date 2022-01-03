package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;

public class EstadoCuchillada {
    public IEstadoCuchilladas estado;
    public EstadoCuchillada() {
        estado = new SinChuchilladas();
    }

    public void avanzarHoras(Calendario calendario) throws PoliciaException {
        estado.avanzarHoras(calendario);
    }

    public void siguienteEstado() {
        estado = estado.siguienteEstado();
    }
}
