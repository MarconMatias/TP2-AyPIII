package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class EmitirOrden implements IAccion {
    private final IOrden orden;
    private Policia policia;

    public EmitirOrden(IOrden orden, Policia policia) {

        if(orden == null && policia == null)
            throw new IllegalArgumentException("El constructor de EmitirOrden fallo porque la orden o el policia no son validos");
        this.orden = orden;
        this.policia = policia;
    }

    @Override
    public String getNombreAccion() {
        return "Emitir orden";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) throws CalendarioException, AccionException {

        try{
            calendario.avanzarHoras(orden.getHorasDemora());
        }
        catch(CalendarioException e){
            throw new CalendarioException("No se pudo avanzar las horas en el calendario");
        }
    }

    @Override
    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    @Override
    public void realizar() throws AccionException {
        try {
            policia.setOrdenDeArresto(orden);
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getStackTrace() + ". El policia no pudo setear la orden de arresto por lo tanto no se pudo emitir");
            throw new AccionException("La orden no se pudo realizar, el policia no pudo setear la orden de arresto");
        }
    }
}
