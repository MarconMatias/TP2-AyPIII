package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.controlador.Orden.DetalleControlador;
import edu.fiuba.algo3.controlador.Orden.DetallesControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Detalles extends ScrollPane {
    List<Detalle> detalles = new ArrayList<>();
    VBox vBox = new VBox();

    public Detalles(Juego juego, Mision mision, DetallesControlador controlador) {
        setContent(vBox);
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        vBox.setSpacing(50);
        setPrefSize(1024,750);
        getStyleClass().add("vistaDetallesOrden");

        Label titulo = new Label("Información recolectada:");
        titulo.setAlignment(Pos.CENTER);
        titulo.setStyle("-fx-font: 90 Impact");
        titulo.getStyleClass().add("etiquetaTituloDetalles");
        vBox.getChildren().add(titulo);

        for(String tipo : mision.obtenerTiposDeDetalles()) {
            Detalle detalle = new Detalle(tipo, mision, new DetalleControlador(tipo, mision));
            vBox.getChildren().add(detalle);
            detalles.add(detalle);
        }
    }
}
