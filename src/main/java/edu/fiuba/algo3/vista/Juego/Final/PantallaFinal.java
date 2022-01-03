package edu.fiuba.algo3.vista.Juego.Final;

import edu.fiuba.algo3.controlador.Juego.Final.PantallaFinalControlador;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class PantallaFinal extends Pantalla {
    protected final Label etiquetaTitulo;
    protected final Label etiquetaMensaje;

    public PantallaFinal(Image fondo, Juego juego, Mision mision, PantallaFinalControlador controlador) {
        super(fondo);
        etiquetaTitulo = new Label("Fin de misión");
        etiquetaTitulo.prefWidthProperty().bind(nuevoXRelativo(0.9));
        etiquetaTitulo.setAlignment(Pos.CENTER);
        etiquetaTitulo.setStyle("-fx-font: 120 Arial");
        etiquetaTitulo.getStyleClass().add("etiquetaTituloFinal");
        agregar(etiquetaTitulo, 0.5, 0.1);

        etiquetaMensaje = new Label(mision.getMensajeMision());
        etiquetaMensaje.prefWidthProperty().bind(nuevoXRelativo(0.4));
        etiquetaMensaje.maxHeightProperty().bind(nuevoYRelativo(0.8));
        etiquetaMensaje.setAlignment(Pos.CENTER);
        etiquetaMensaje.setStyle("-fx-font: 100 Arial");
        etiquetaMensaje.setWrapText(true);
        etiquetaMensaje.getStyleClass().add("etiquetaMensajeFinal");
        agregar(etiquetaMensaje, 0.3, 0.5);

        Label textoContinuar = new Label("Hacé click o presioná una tecla para continuar…");
        textoContinuar.prefWidthProperty().bind(nuevoXRelativo(0.9));
        textoContinuar.setAlignment(Pos.CENTER);
        textoContinuar.setStyle("-fx-font: 100 Arial");
        textoContinuar.getStyleClass().add("textoContinuarFinal");
        agregar(textoContinuar, 0.5, 0.9);

        this.setFocusTraversable(true);
        iniciarControlador(controlador);
    }

    @Override
    protected void iniciarControlador(PantallaControlador controlador) {
        super.iniciarControlador(controlador);
        setOnMouseClicked(controlador::fondoClicked);
        setOnKeyPressed(controlador::fondoKeyPressed);
    }
}
