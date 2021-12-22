package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.controlador.Orden.DetallesControlador;
import edu.fiuba.algo3.controlador.Orden.OrdenControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class Orden extends Pantalla {
    private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Orden/Orden_3840.jpeg"));
    private final Juego juego;
    private final Mision mision;
    private final OrdenControlador controlador;
    private final Librito librito;

    public Orden(Juego juego, Mision mision, OrdenControlador controlador) {
        super(fondo);
        this.juego = juego;
        this.mision = mision;
        this.controlador = controlador;

        Label tituloOrden = new Label();
        tituloOrden.setText("Orden de arresto");
        tituloOrden.setAlignment(Pos.CENTER);
        tituloOrden.setMaxWidth(960);
        tituloOrden.setStyle("-fx-font: 100 Impact");
        tituloOrden.getStyleClass().add("etiquetaTituloOrden");
        agregar(tituloOrden, 0.400, 0.12);

        Label tituloSospechosos = new Label();
        tituloSospechosos.setText("Sospechosos:");
        tituloSospechosos.setAlignment(Pos.CENTER);
        tituloSospechosos.setMaxWidth(960);
        tituloSospechosos.setStyle("-fx-font: 90 \"Comic Sans\"");
        tituloSospechosos.getStyleClass().add("etiquetaTituloSospechosos");
        tituloSospechosos.getTransforms().setAll(new Rotate(5d, 0,0));
        agregar(tituloSospechosos, 0.805, 0.330);

        Detalles detallesPane = new Detalles(juego, mision, new DetallesControlador(juego, mision));
        agregar(detallesPane, 0.4, 0.4);

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);

        setRadio(juego.getRadio());
        setControlador(controlador);
    }

    private void setControlador(OrdenControlador controlador) {
        if(null == controlador) {
            return;
        }
        librito.setOnMouseClicked(controlador::libritoClicked);
        librito.setOnKeyPressed(controlador::libritoKeyPressed);
    }
}
