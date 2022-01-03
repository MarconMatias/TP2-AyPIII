package edu.fiuba.algo3.modelo.Calendario.Acciones;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
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
    public void avanzarCalendario(Calendario calendario) throws PoliciaException {
        try {
            calendario.avanzarHoras(orden.getHorasDemora());
        } catch (CalendarioException e) {
            throw new PoliciaException("Error. El policia no pudo avanzar las horas: " + e.getMessage());
        }
    }

    @Override
    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    @Override
    public void realizar() throws PoliciaException {
        if(null != policia) {
                policia.setOrdenDeArresto(orden);
        }
    }
}
