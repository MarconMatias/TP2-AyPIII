package edu.fiuba.algo3.vista.Calendario;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TextoReloj extends HBox {
    public TextoReloj(Label... etiquetas) {
        super(etiquetas);
        setSpacing(0);
        for(Label etiqueta : etiquetas) {
            etiqueta.setAlignment(Pos.CENTER);
            etiqueta.setMinWidth(60);
            etiqueta.setStyle("-fx-font: 60 Impact");
            etiqueta.getStyleClass().add("etiquetaTextoReloj");
        }
    }
}
