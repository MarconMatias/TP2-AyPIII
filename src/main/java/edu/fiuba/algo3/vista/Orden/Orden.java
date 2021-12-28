package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.controlador.Orden.DetallesControlador;
import edu.fiuba.algo3.controlador.Orden.OrdenControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringBinding;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import static javafx.beans.binding.Bindings.*;

public class Orden extends Pantalla {
    private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Orden/Orden_3840.jpeg"));
    private final Juego juego;
    private final Mision mision;
    private final OrdenControlador controlador;
    private final Librito librito;
    private final Button botonEmitir;
    private final Detalles detallesPane;
    protected final Label tituloHoja;
    protected final Sospechosos sospechosos;

    public Orden(Juego juego, Mision mision, OrdenControlador controlador) {
        super(fondo);
        this.juego = juego;
        this.mision = mision;
        this.controlador = controlador;

        tituloHoja = crearTituloHoja("Orden de arresto");

        sospechosos = new Sospechosos(juego, mision, controlador.crearControladorSospechosos());
        agregar(sospechosos, 0.81, 0.535);

        Label tituloSospechosos = new Label();
        tituloSospechosos.setText("Sospechosos:");
        tituloSospechosos.setAlignment(Pos.CENTER);
        tituloSospechosos.setMaxWidth(960);
        tituloSospechosos.setStyle("-fx-font: 90 \"Comic Sans\"");
        tituloSospechosos.textFillProperty().bind(
                createObjectBinding(
                        ()->sospechosos.isFocused()?Color.BLUE:Color.BLACK,
                        sospechosos.focusedProperty()));
        tituloSospechosos.getStyleClass().add("etiquetaTituloSospechosos");
        tituloSospechosos.getTransforms().setAll(new Rotate(5d, 0, 0));
        agregar(tituloSospechosos, 0.805, 0.330);

        Label labelEstado = new Label();
        StringBinding bindingEstado = createStringBinding(this::textoEstado, mision.getOrden());
        labelEstado.textProperty().bind(bindingEstado);
        labelEstado.setAlignment(Pos.CENTER);
        labelEstado.setMinWidth(720);
        labelEstado.setMinHeight(256);
        labelEstado.setWrapText(true);
        labelEstado.setStyle("-fx-font: 90 \"Comic Sans\"");
        labelEstado.getStyleClass().add("etiquetaEstadoOrden");
        labelEstado.getTransforms().setAll(new Rotate(5d, 0,0));
        agregar(labelEstado, 0.4, 0.70);

        botonEmitir = new Button("SOLICITAR ORDEN");
        botonEmitir.setAlignment(Pos.CENTER);
        final double widthBotonEmitir = 720;
        botonEmitir.setMinWidth(widthBotonEmitir);
        botonEmitir.setPrefWidth(widthBotonEmitir);
        botonEmitir.setMaxWidth(widthBotonEmitir);
        botonEmitir.setStyle("-fx-font: 60 \"Comic Sans\"");
        botonEmitir.getStyleClass().add("botonEmitirOrden");
        botonEmitir.getTransforms().setAll(new Rotate(5d, 0,0));
        BooleanBinding bindingEmitirVisible = createBooleanBinding(
                ()->(1 == mision.getSospechososObservables().size()),
                mision.getSospechososObservables());
        botonEmitir.visibleProperty().bind(bindingEmitirVisible);
        agregar(botonEmitir, 0.81, 0.5);

        detallesPane = new Detalles(juego, mision, mision, new DetallesControlador(juego, mision));
        detallesPane.setTitulo("Información recolectada:");
        agregar(detallesPane, 0.4, 0.4);

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);

        setCalendario(mision.getCalendario());
        setRelojVisible(true);
        setRadio(juego.getRadio());
        setControlador(controlador);
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

    private String textoEstado() {
        String emitidaPara = mision.getOrden().get().getEmitidaPara();
        if(null == emitidaPara) {
            return "Sin emitir";
        }
        return "Emitida para\n"+emitidaPara;
    }

    private void setControlador(OrdenControlador controlador) {
        if (null == controlador) {
            return;
        }
        observadorAccionesProperty().bind(controlador.getObservadorLiberable());
        librito.setOnMouseClicked(controlador::libritoClicked);
        librito.setOnKeyPressed(controlador::libritoKeyPressed);
        botonEmitir.setOnAction(controlador::emitir);
    }
}
