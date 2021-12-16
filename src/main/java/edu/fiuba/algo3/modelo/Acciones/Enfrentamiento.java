package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Enfrentamiento implements IAccion {
    private final Ladron ladron;
    private Policia policia;

    public Enfrentamiento(Ladron ladron) {
        this.ladron = ladron;
    }

    @Override
    public String getNombreAccion() {
        return "Enfrentamiento";
    }

    @Override
    public void avanzarCalendario(Calendario calendario) {
        // No avanza el calendario
    }

    @Override
    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    @Override
    public void realizar() {
        policia.enfrentar(ladron);
    }
}
