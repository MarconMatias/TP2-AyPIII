package edu.fiuba.algo3.vista.Juego;

import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import javafx.scene.image.Image;

public class Pantalla extends RelativoAImagen {
    public Pantalla(Image imagen) {
        super(imagen);
    }

    public Pantalla(String path) {
        super(path);
    }
}
