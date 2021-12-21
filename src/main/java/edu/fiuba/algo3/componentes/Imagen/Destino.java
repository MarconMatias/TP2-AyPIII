package edu.fiuba.algo3.componentes.Imagen;

import edu.fiuba.algo3.componentes.bindings.BooleanDoubleBinding;
import javafx.scene.image.Image;

public class Destino extends ImagenSeleccionable {
    private static final double ordenSeleccionado = -20;
    private static final double ordenDeseleccionado = -19;
    private static final Image sel = new Image(urlDesdeRecursos("Ciudad/DestinoCiudad_640_sel.png"));
    private static final Image desel = new Image(urlDesdeRecursos("Ciudad/DestinoCiudad_640_desel.png"));
    private String nombre;

    public Destino(Image imageSel, Image imageDesel, String nombre) {
        super(imageSel, imageDesel);
        BooleanDoubleBinding orden = new BooleanDoubleBinding(focusedProperty(),
                ordenSeleccionado,
                ordenDeseleccionado);
        viewOrderProperty().bind(orden);
        this.nombre = nombre;
    }

    public Destino(String nombre) {
        this(getImageSel(), getImageDesel(), nombre);
    }

    protected static Image getImageDesel() {
        return desel;
    }

    protected static Image getImageSel() {
        return sel;
    }

    public String getNombre() {
        return nombre;
    }
}
