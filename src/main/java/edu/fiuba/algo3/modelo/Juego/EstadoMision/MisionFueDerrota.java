package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public class MisionFueDerrota implements IEstadoMision {
    private final String explicacion;

    public MisionFueDerrota(String explicacion) {
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
}
