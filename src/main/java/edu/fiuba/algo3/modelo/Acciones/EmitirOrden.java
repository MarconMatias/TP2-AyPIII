package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class EmitirOrden implements IAccion {
    private final IOrden orden;
    private Policia policia;

    public EmitirOrden(IOrden orden, Policia policia) {
        this.orden = orden;
        this.policia = policia;
    }

    @Override
    public String getNombreAccion() {
        return "Emitir orden";
    }

    @Override
    public String getTextoAccion()
    {
        return "Su orden de arresto está emitiéndose…";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) {
        calendario.avanzarHoras(orden.getHorasDemora());
    }

    @Override
    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    @Override
    public void realizar() {
        if(null != policia) {
            policia.setOrdenDeArresto(orden);
        }
    }
}
