package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
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
    public String getTextoAccion()
    {
        return "Te achuchillaron, necesitás recuperarte…";
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
