package edu.fiuba.algo3.modelo.Policia.EstadoCuchillada;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.EstadoCuchillada.IEstadoCuchilladas;

public class SinChuchilladas implements IEstadoCuchilladas {
    @Override
    public void avanzarHoras(Calendario calendario) throws AccionException, CalendarioException {
        if(calendario == null)
            throw new IllegalArgumentException("Error. El Calendario pasado por parametro no es valido");
        try{
            calendario.avanzarHoras(2);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    @Override
    public IEstadoCuchilladas siguienteEstado() {
        return new UnaChuchillada();
    }
}
