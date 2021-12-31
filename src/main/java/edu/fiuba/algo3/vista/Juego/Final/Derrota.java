package edu.fiuba.algo3.vista.Juego.Final;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.controlador.Juego.Final.PantallaFinalControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.image.Image;

public class Derrota extends PantallaFinal {
    private static final Image fondo = new Image(Imagen.urlDesdeRecursos("Juego/derrota.jpeg"));
    public Derrota(Juego juego, Mision mision, PantallaFinalControlador controlador) {
        super(fondo, juego, mision, controlador);
        etiquetaTitulo.setText("Derrota \uD83D\uDE14");
    }
}
