package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public class MisionFueDerrota implements IEstadoMision {
    @Override
    public boolean fueFinalizada() {
        return true;
    }

    @Override
    public boolean fueVictoria() {
        return false;
    }

    @Override
    public IEstadoMision convertirEnDerrota() {
        return this;
    }

    @Override
    public IEstadoMision convertirEnVictoria() {
        return this;
    }
}
