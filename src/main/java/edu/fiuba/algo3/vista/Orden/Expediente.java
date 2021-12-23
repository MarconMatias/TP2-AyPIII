package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.controlador.Orden.ExpedienteControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public class Expediente extends RelativoAImagen {
  private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Orden/Orden_3840.jpeg"));
  private final double anguloRotacion = -9;
  private final Juego juego;
  private final Mision mision;
  private final ExpedienteControlador controlador;

  public Expediente(Juego juego, Mision mision, ExpedienteControlador controlador) {
    super(fondo);

    this.juego = juego;
    this.mision = mision;
    this.controlador = controlador;

    Label tituloExpediente = new Label();
    tituloExpediente.setText("Expediente");
    tituloExpediente.setAlignment(Pos.CENTER);
    tituloExpediente.setMaxWidth(960);
    tituloExpediente.setStyle("-fx-font: 100 Impact");
    tituloExpediente.getStyleClass().add("etiquetaTituloSospechosos");
    tituloExpediente.getTransforms().setAll(new Rotate(5d, 0, 0));
    agregar(tituloExpediente, 0.805, 0.330);

    Sospechosos sospechosos = new Sospechosos(juego, mision, controlador.crearControladorSospechosos());
    agregar(sospechosos, 0.81, 0.535);

  }
}
