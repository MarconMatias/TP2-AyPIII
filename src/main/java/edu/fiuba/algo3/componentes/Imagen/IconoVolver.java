package edu.fiuba.algo3.componentes.Imagen;

import javafx.scene.image.Image;

public class IconoVolver extends ImagenSeleccionable {

    private final static Image sel = new Image(urlDesdeRecursos("Juego/Volver_sel.png"));
    private final static Image desel = new Image(urlDesdeRecursos("Juego/Volver_desel.png"));

    public IconoVolver() {
        super(sel,desel);
    }

    public IconoVolver(double ancho) {
        this();
        setWidth(ancho);
    }


}
