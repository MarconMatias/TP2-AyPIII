package edu.fiuba.algo3.modelo.Juego.EstadoMision;

public class EstadoMision {
    private IEstadoMision estado = new MisionEnJuego();

    public boolean fueFinalizada() {
        return estado.fueFinalizada();
    }

    public boolean fueVictoria() {
        return estado.fueVictoria();
    }

    public void hacerDerrota(String explicacion) {
        estado = estado.convertirEnDerrota(explicacion);
    }

    public void hacerVictoria(String explicacion) {
        estado = estado.convertirEnVictoria(explicacion);
    }

    public String getExplicacion() {
        return estado.getExplicacion();
    }
}
