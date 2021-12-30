package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;

public class EstadoCuchillada {
    public IEstadoCuchilladas estado;
    public EstadoCuchillada() {
        estado = new SinChuchilladas();
    }

    public void avanzarHoras(Calendario calendario) throws AccionException, CalendarioException {
        try{
            estado.avanzarHoras(calendario);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void siguienteEstado() {
        estado = estado.siguienteEstado();
    }
}
