package edu.fiuba.algo3.modelo.Juego.EstadoMision;

import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class MisionEnJuego implements IEstadoMision {
    private final Item itemRobado;
    private final Ladron ladron;

    public MisionEnJuego(Item itemRobado, Ladron ladron) {
        this.itemRobado = itemRobado;
        this.ladron = ladron;
    }

    @Override
    public boolean fueFinalizada() {
        return false;
    }

    @Override
    public boolean fueVictoria() {
        return false;
    }

    @Override
    public IEstadoMision convertirEnDerrota(String explicacion) {
        return new MisionFueDerrota(itemRobado, ladron, explicacion);
    }

    @Override
    public IEstadoMision convertirEnVictoria(String explicacion) {
        return new MisionFueVictoria(itemRobado, ladron, explicacion);
    }

    @Override
    public String getExplicacion() {
        return "";
    }

    @Override
    public String getMensaje() {
        String texto = itemRobado.getTextoEnJuego();
        texto += ladron.getTextoMision() + " ";
        texto += "Tenés tiempo hasta el domingo a las 17 hs., ¡éxitos!";
        return texto;
    }
}
