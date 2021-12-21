package edu.fiuba.algo3.componentes.Imagen;

public class Logo extends Imagen {
    private static final double viewOrder = -40;

    public Logo() {
        super(urlDesdeRecursos("logo.png"));
        this.setViewOrder(viewOrder);
    }

    public Logo(double ancho) {
        this();
        double alto =  getImage().getHeight() * ancho/ getImage().getWidth();
        setFitHeight(alto);
        setFitWidth(ancho);
    }
}
