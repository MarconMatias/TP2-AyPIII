package edu.fiuba.algo3.componentes.Libro;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.scene.image.Image;

public class Libro extends Pantalla {
    private static Image fondo = new Image(Imagen.urlDesdeRecursos("Libro_3840.jpeg"));
    public Libro() {
        super(fondo);
    }
}
