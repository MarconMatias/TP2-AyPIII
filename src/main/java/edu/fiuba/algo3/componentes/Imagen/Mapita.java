package edu.fiuba.algo3.componentes.Imagen;

import javafx.scene.image.Image;

public class Mapita extends ImagenSeleccionable {

    private final static Image sel = new Image(urlDesdeRecursos("Mapa/Mapita_sel.png"));
    private final static Image desel = new Image(urlDesdeRecursos("Mapa/Mapita_desel.png"));

    public Mapita() {
        super(sel,desel);
    }

    public Mapita(double ancho) {
        this();
        setWidth(ancho);
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
