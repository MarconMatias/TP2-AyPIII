package edu.fiuba.algo3.modelo.Juego.EstadoMision;

import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class MisionFueDerrota implements IEstadoMision {
    private final Item itemRobado;
    private final Ladron ladron;
    private final String explicacion;

    public MisionFueDerrota(Item itemRobado, Ladron ladron, String explicacion) {
        this.itemRobado = itemRobado;
        this.ladron = ladron;
        this.explicacion = explicacion;
    }

    @Override
    public boolean fueFinalizada() {
        return true;
    }

    @Override
    public boolean fueVictoria() {
        return false;
    }

    @Override
    public IEstadoMision convertirEnDerrota(String explicacion) {
        return this;
    }

    @Override
    public IEstadoMision convertirEnVictoria(String explicacion) {
        return this;
    }

    @Override
    public String getExplicacion() {
        return explicacion;
    }

    @Override
    public String getMensaje() {
        String texto = itemRobado.getTextoDerrota();
        texto += explicacion + " ¡Confiamos en que tu siguiente misión tendrá mayor éxito!";
        return texto;
    }
}
