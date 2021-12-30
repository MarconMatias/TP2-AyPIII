package edu.fiuba.algo3.vista.Juego.Final;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.controlador.Juego.Final.PantallaFinalControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.image.Image;

public class Victoria extends PantallaFinal {
    private static final Image fondo = new Image(Imagen.urlDesdeRecursos("Juego/victoria.jpeg"));

    public Victoria(Juego juego, Mision mision, PantallaFinalControlador controlador) {
        super(fondo, juego, mision, controlador);
        etiquetaTitulo.setText("¡Victoria!");
    }
}
