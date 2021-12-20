package edu.fiuba.algo3.componentes.Imagen;

public class Avion extends Imagen {
    private static final double viewOrder = -50;

    public Avion() {
        super(urlDesdeRecursos("avion.png"));
        this.setViewOrder(viewOrder);
        this.setFitWidth(128);
        this.setFitHeight(128);
    }
}
