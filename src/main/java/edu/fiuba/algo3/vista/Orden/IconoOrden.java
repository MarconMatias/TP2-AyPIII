package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.ImagenSeleccionable;
import javafx.scene.image.Image;

public class IconoOrden extends ImagenSeleccionable {

    private final static Image sel = new Image(urlDesdeRecursos("Orden/Orden_sel.png"));
    private final static Image desel = new Image(urlDesdeRecursos("Orden/Orden_desel.png"));

    public IconoOrden() {
        super(sel,desel);
    }

    public IconoOrden(double ancho) {
        this();
        setWidth(ancho);
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
