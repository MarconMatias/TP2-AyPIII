package edu.fiuba.algo3.modelo.Juego.EstadoMision;

import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class MisionFueVictoria implements IEstadoMision {
    private final Item itemRobado;
    private final Ladron ladron;
    private final String explicacion;

    public MisionFueVictoria(Item itemRobado, Ladron ladron, String explicacion) {
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
        return true;
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
        String texto = itemRobado.getTextoVictoria();
        texto += explicacion + " ¡Felicidades, no esperábamos menos de vos!";
        return texto;
    }
}
