package edu.fiuba.algo3.modelo.Juego.EstadoMision;

import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class EstadoMision {
    private IEstadoMision estado;

    public EstadoMision(Item itemRobado, Ladron ladron) {
        estado = new MisionEnJuego(itemRobado, ladron);
    }

    public boolean fueFinalizada() {
        return estado.fueFinalizada();
    }

    public boolean fueVictoria() {
        return estado.fueVictoria();
    }

    public void hacerDerrota(String explicacion) {
        estado = estado.convertirEnDerrota(explicacion);
    }

    public void hacerVictoria(String explicacion) {
        estado = estado.convertirEnVictoria(explicacion);
    }

    public String getExplicacion() {
        return estado.getExplicacion();
    }

    public String getMensaje() {
        return estado.getMensaje();
    }
}
