package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.IEstado;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class HeridaPorCuchillo implements IAccion, IComportamientoAccion{
    private int demoraAccion;
    private AccionCuchilloUnica estado;
    @Override
    public void reaccion(Calendario calendario, Policia policia /* Por las dudas */) {
        demoraAccion = estado.demoraEdificio();
        calendario.avanzarHoras(demoraAccion);
        // Mati - No se bien que haria el policia como reaccion a la accion
    }

    @Override
    public String getNombreAccion() {
        return "Herido por cuchillo";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) {
        /** Falta comportamiento por cantidad */
        calendario.avanzarHoras(2);
    }
}
