package edu.fiuba.algo3.componentes.Libro;

import edu.fiuba.algo3.componentes.Imagen.ImagenSeleccionable;
import javafx.scene.image.Image;

public class Librito extends ImagenSeleccionable {

    private final static Image sel = new Image(urlDesdeRecursos("Ciudad/Librito_sel.png"));
    private final static Image desel = new Image(urlDesdeRecursos("Ciudad/Librito_desel.png"));

    public Librito() {
        super(sel,desel);
    }

    public Librito(double ancho) {
        this();
        setWidth(ancho);
    }

}
