package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.controlador.Orden.DocumentosControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.scene.image.Image;

public class Documentos extends Pantalla {
    private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Orden/Orden_3840.jpeg"));

    public Documentos(Juego juego, Mision mision, DocumentosControlador controlador) {
        super(fondo);
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
