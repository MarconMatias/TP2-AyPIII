package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.controlador.Orden.OrdenControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import javafx.scene.control.ListView;
import javafx.scene.transform.Rotate;

public class Sospechosos extends ListView<Ladron> {

  private final double anguloRotacion = 5;

  public Sospechosos(Juego juego, Mision mision, OrdenControlador controlador) {
    super(mision.getSospechososObservables());

    this.setPrefWidth(1536);
    this.setPrefHeight(920);
    this.setStyle("-fx-font: 80 Impact");
    this.getStyleClass().add("listaSospechosos");
    this.getTransforms()
        .setAll(new Rotate(anguloRotacion, this.getWidth() / 2, this.getHeight() / 2));
  }
}
