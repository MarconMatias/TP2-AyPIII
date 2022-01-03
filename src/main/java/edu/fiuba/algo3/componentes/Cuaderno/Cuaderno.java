package edu.fiuba.algo3.componentes.Cuaderno;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.scene.image.Image;

public class Cuaderno extends Pantalla {
    private static Image fondo = new Image(Imagen.urlDesdeRecursos("Cuaderno_3840.jpeg"));
    public Cuaderno() {
        super(fondo);
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
