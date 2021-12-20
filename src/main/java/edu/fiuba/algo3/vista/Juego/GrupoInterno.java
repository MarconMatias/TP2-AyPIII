package edu.fiuba.algo3.vista.Juego;

import javafx.scene.Group;
import javafx.scene.Node;

public class GrupoInterno extends Group {
    public GrupoInterno(Node... nodos) {
        super(nodos);
    }

    public void cambiar(Node... nodos) {
        this.getChildren().clear();
        this.getChildren().setAll(nodos);
    }
}
