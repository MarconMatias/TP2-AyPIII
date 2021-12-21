package edu.fiuba.algo3.componentes.Imagen;

import javafx.geometry.Point2D;

public class Destino extends Imagen {
    private static final double viewOrder = -20;
    private String nombre;

    public Destino(String nombre) {
        super(urlDesdeRecursos("destino3.png"));
        this.setViewOrder(viewOrder);
        this.nombre = nombre;
        this.setFitWidth(96);
        this.setFitHeight(96);
    }

    public String getNombre() {
        return nombre;
    }
}
