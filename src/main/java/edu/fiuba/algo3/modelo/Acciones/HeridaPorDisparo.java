package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class HeridaPorDisparo implements IComportamientoAccion, IAccion {

    @Override
    public void reaccion(Calendario calendario, Policia policia) {
        //calendario.avanzarHoras(4);
        // Mati - No se bien que haria el policia como reaccion a la accion
    }

    @Override
    public String getNombreAccion() {
        return "Disparo";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) {
        calendario.avanzarHoras(4);
    }

    @Override
    public void setPolicia(Policia policia) {
        /** No debe hacer nada porque no interactúa. **/
    }

    @Override
    public void realizar() {
        /** No debe hacer nada porque no cambia el esado. **/
    }
}
