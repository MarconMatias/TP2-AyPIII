package edu.fiuba.algo3.componentes.Imagen;

import javafx.scene.image.Image;

public class IconoEdificios extends ImagenSeleccionable {
    /** \todo Poner nombres de imágenes correctas cuando estén disponibles. **/
    private final static Image sel = new Image(urlDesdeRecursos("Edificio/Planito_sel.png"));
    private final static Image desel = new Image(urlDesdeRecursos("Edificio/Planito_desel.png"));

    public IconoEdificios() {
        super(sel,desel);
    }

    /**
     * Crea una imagen seleccionable a modo de ícono, con el ancho dado.
     *
     * @param ancho Ancho en píxeles.
     */
    public IconoEdificios(double ancho) {
        this();
        setWidth(ancho);
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
