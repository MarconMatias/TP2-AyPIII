package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public class MisionFueVictoria implements IEstadoMision {
    private final String explicacion;

    public MisionFueVictoria(String explicacion) {
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
}
