package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public class MisionEnJuego implements IEstadoMision {
    @Override
    public boolean fueFinalizada() {
        return false;
    }

    @Override
    public boolean fueVictoria() {
        return false;
    }

    @Override
    public IEstadoMision convertirEnDerrota() {
        return new MisionFueDerrota();
    }

    @Override
    public IEstadoMision convertirEnVictoria() {
        return new MisionFueVictoria();
    }
}
