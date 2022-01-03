package edu.fiuba.algo3.modelo.Juego;

public interface IObservadorMision {
    /**
     * El objeto mision sufrió un cambio.
     * @param mision Objeto que sufrió un cambio.
     */
    void misionCambia(Mision mision);
}
