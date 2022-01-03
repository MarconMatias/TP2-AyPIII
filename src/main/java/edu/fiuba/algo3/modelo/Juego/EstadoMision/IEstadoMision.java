package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public interface IEstadoMision {
    boolean fueFinalizada();

    boolean fueVictoria();

    IEstadoMision convertirEnDerrota(String explicacion);

    IEstadoMision convertirEnVictoria(String explicacion);

    String getExplicacion();

    String getMensaje();
}
