package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.controlador.Orden.OrdenControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.transform.Rotate;

public class Orden extends RelativoAImagen {
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

        HBox rasgo1 = new HBox() {
            {
                Label titulo = new Label("Pelo:");
                titulo.setAlignment(Pos.TOP_LEFT);
                titulo.setMinWidth(480);
                titulo.setMaxWidth(480);
                titulo.setStyle("-fx-font: 60 Arial");
                setHgrow(titulo, Priority.ALWAYS);

                Label valor = new Label("Rojo");
                valor.setAlignment(Pos.TOP_LEFT);
                valor.setMinWidth(480);
                valor.setMaxWidth(480);
                valor.setStyle("-fx-font: 60 \"Times New Roman\"");
                setHgrow(valor, Priority.ALWAYS);

                setSpacing(10);
                setMinWidth(480*2+10);

                this.getChildren().setAll(titulo, valor);
            }
        };

        agregar(rasgo1, 0.4, 0.22);

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
