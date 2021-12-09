package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class HeridaPorDisparo implements IComportamientoAccion{

    @Override
    public void reaccion(Calendario calendario, Policia policia) {
        calendario.avanzarHoras(4);
        // Mati - No se bien que haria el policia como reaccion a la accion
    }
    
}
