package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public class MisionFueVictoria implements IEstadoMision {
    @Override
    public boolean fueFinalizada() {
        return true;
    }

    @Override
    public boolean fueVictoria() {
        return true;
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
