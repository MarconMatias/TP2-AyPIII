package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public interface IEstadoMision {
    boolean fueFinalizada();

    boolean fueVictoria();

    IEstadoMision convertirEnDerrota();

    IEstadoMision convertirEnVictoria();
}
