package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Calendario.Calendario;

public class EstadoCuchillada {
    public IEstadoCuchilladas estado;
    public EstadoCuchillada() {
        estado = new SinChuchilladas();
    }

    public void avanzarHoras(Calendario calendario) {
        estado.avanzarHoras(calendario);
    }

    public void siguienteEstado() {
        estado = estado.siguienteEstado();
    }
}
