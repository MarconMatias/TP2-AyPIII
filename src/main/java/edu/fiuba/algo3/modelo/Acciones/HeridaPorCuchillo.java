package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.IEstado;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class HeridaPorCuchillo implements IAccion {
    private int demoraAccion;
    private AccionCuchilloUnica estado;
    private Policia policia;

    @Override
    public String getNombreAccion() {
        return "Herido por cuchillo";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) throws AccionException, CalendarioException {

        try{
            policia.avanzarHorasCuchillada(calendario);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            System.err.println(e.getMessage());

        }
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
