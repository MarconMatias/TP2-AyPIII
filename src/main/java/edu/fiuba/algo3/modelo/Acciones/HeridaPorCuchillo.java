package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.IEstado;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class HeridaPorCuchillo implements IAccion, IComportamientoAccion{
    private int demoraAccion;
    private AccionCuchilloUnica estado;
    private Policia policia;

    @Override
    public void reaccion(Calendario calendario, Policia policia) {
        //demoraAccion = estado.demoraEdificio();
        //calendario.avanzarHoras(demoraAccion);
        // Mati - No se bien que haria el policia como reaccion a la accion
    }

    @Override
    public String getNombreAccion() {
        return "Herido por cuchillo";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) {
        policia.avanzarHorasCuchillada(calendario);
    }

    @Override
    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    @Override
    public void realizar() {
       policia.recibirCuchillada();
    }
}
