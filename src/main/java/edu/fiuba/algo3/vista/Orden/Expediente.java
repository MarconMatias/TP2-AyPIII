package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.IconoVolver;
import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Imagen.ImagenSeleccionable;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.controlador.Orden.ExpedienteControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import static javafx.beans.binding.Bindings.createObjectBinding;

public class Expediente extends Pantalla {
  private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Orden/Orden_3840.jpeg"));
  private final double anguloRotacion = -9;
  private final Juego juego;
  private final Mision mision;
  private final ExpedienteControlador controlador;
  private final Librito librito;
  private final ImagenSeleccionable orden;
  private final Detalles detallesPane;
  private final Label tituloHoja;

  public Expediente(Juego juego, Mision mision, Ladron ladron, ExpedienteControlador controlador) {
    super(fondo);

    this.juego = juego;
    this.mision = mision;
    this.controlador = controlador;

    tituloHoja = crearTituloHoja(ladron.getNombre());

    Sospechosos sospechosos = new Sospechosos(juego, mision, controlador.crearControladorSospechosos());
    agregar(sospechosos, 0.81, 0.535);

    Label tituloSospechosos = new Label();
    tituloSospechosos.setText("Sospechosos:");
    tituloSospechosos.setAlignment(Pos.CENTER);
    tituloSospechosos.setMaxWidth(960);
    tituloSospechosos.setStyle("-fx-font: 90 \"Comic Sans\"");
    tituloSospechosos.textFillProperty().bind(
            createObjectBinding(
                    ()->sospechosos.isFocused()? Color.BLUE:Color.BLACK,
                    sospechosos.focusedProperty()));
    tituloSospechosos.getStyleClass().add("etiquetaTituloSospechosos");
    tituloSospechosos.getTransforms().setAll(new Rotate(5d, 0, 0));
    agregar(tituloSospechosos, 0.805, 0.330);

    detallesPane = new Detalles(juego, mision, ladron, null);
    detallesPane.setTitulo("Expediente:");
    agregar(detallesPane, 0.4, 0.4);


    librito = new Librito(640);
    agregar(librito, 0.08, 0.4);

    orden = new IconoVolver(640);
    agregar(orden, 0.75, 0.9);

    setTarjetasVisible(true);
    setCalendario(mision.getCalendario());
    setRelojVisible(true);
    setRadio(juego.getRadio());
    iniciarControlador(controlador);
  }

  private Label crearTituloHoja(String titulo) {
    Label tituloHoja = new Label();
    tituloHoja.setText(titulo);
    tituloHoja.setAlignment(Pos.CENTER);
    tituloHoja.setMaxWidth(960);
    tituloHoja.setStyle("-fx-font: 100 Impact");
    tituloHoja.getStyleClass().add("etiquetaTituloOrden");
    return (Label) agregar(tituloHoja, 0.400, 0.12);
  }

  @Override
  protected void iniciarControlador(PantallaControlador controlador) {
    super.iniciarControlador(controlador);
    if(null == controlador) {
      return;
    }
    observadorAccionesProperty().bind(controlador.getObservadorLiberable());
    if(null != librito) {
      librito.setOnMouseClicked(controlador::libritoClicked);
      librito.setOnKeyPressed(controlador::libritoKeyPressed);
    }
    if(null != orden) {
      orden.setOnMouseClicked(controlador::ordenClicked);
      orden.setOnKeyPressed(controlador::ordenKeyPressed);
    }
  }

  @Override
  public String getTitulo() {
    return "Elija un sospechoso para ver sus detalles";
  }
}
