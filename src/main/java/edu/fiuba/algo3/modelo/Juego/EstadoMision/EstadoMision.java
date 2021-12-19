package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public class EstadoMision {
    private IEstadoMision estado = new MisionEnJuego();

    public boolean fueFinalizada() {
        return estado.fueFinalizada();
    }

    public boolean fueVictoria() {
        return estado.fueVictoria();
    }

    public void hacerDerrota() {
        estado = estado.convertirEnDerrota();
    }

    public void hacerVictoria() {
        estado = estado.convertirEnVictoria();
    }
}
