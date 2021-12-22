package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Detalle extends HBox {
    public Detalle(String tipo, Mision mision) {
        Label titulo = new Label(tipo + ":");
        titulo.setAlignment(Pos.TOP_LEFT);
        titulo.setMinWidth(480);
        titulo.setMaxWidth(480);
        titulo.setStyle("-fx-font: 60 Arial");
        setHgrow(titulo, Priority.ALWAYS);

        Label valor = new Label(mision.getDetalle(tipo));
        valor.setAlignment(Pos.TOP_LEFT);
        valor.setMinWidth(480);
        valor.setMaxWidth(480);
        valor.setStyle("-fx-font: 60 \"Times New Roman\"");
        setHgrow(valor, Priority.ALWAYS);

        setSpacing(10);
        setMinWidth(480*2+10);

        this.getChildren().setAll(titulo, valor);
    }
}
