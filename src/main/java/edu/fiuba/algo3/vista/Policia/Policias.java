package edu.fiuba.algo3.vista.Policia;

import edu.fiuba.algo3.componentes.Cuaderno.Cuaderno;
import edu.fiuba.algo3.controlador.Policia.PoliciaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.transform.Rotate;

public class Policias extends Cuaderno {
    private final double anguloRotacion = -9;
    private final TextField nombreNuevo;
    private final Button botonNuevo;
    private final ListView<Policia> listaPolicias;
    private PoliciaControlador controlador;

    public Policias(Juego juego, PoliciaControlador controlador) {
        super();
        Label etiquetaNuevo = new Label("Ingresante:");
        etiquetaNuevo.setAlignment(Pos.CENTER);
        etiquetaNuevo.setStyle("-fx-font: 120 Impact");
        etiquetaNuevo.getStyleClass().add("etiquetaNuevoIngresante");
        etiquetaNuevo.getTransforms().setAll(new Rotate(anguloRotacion, 0, 0));
        agregar(etiquetaNuevo, 0.325, 0.325);

        nombreNuevo = new TextField();
        nombreNuevo.setPromptText("Tu nombre");
        nombreNuevo.setAlignment(Pos.CENTER);
        nombreNuevo.setStyle("-fx-font: 120 Impact");
        nombreNuevo.getStyleClass().add("valorNuevoIngresante");
        nombreNuevo.setPrefWidth(1024);
        nombreNuevo.getTransforms()
                .setAll(new Rotate(anguloRotacion, nombreNuevo.getWidth() / 2, nombreNuevo.getHeight() / 2));
        agregar(nombreNuevo, 0.535, 0.29);

        botonNuevo = new Button("▶");
        botonNuevo.setPrefWidth(120);
        botonNuevo.setPrefHeight(120);
        botonNuevo.setStyle("-fx-font: 80 Impact");
        botonNuevo.getStyleClass().add("botonNuevoIngresante");
        botonNuevo.getTransforms()
                .setAll(new Rotate(anguloRotacion, botonNuevo.getWidth() / 2, botonNuevo.getHeight() / 2));
        agregar(botonNuevo, 0.69, 0.22);

        listaPolicias = new ListView<Policia>(juego.getPolicias());
        listaPolicias.setPrefWidth(1536);
        listaPolicias.setPrefHeight(920);
        listaPolicias.setStyle("-fx-font: 80 Impact");
        listaPolicias.getStyleClass().add("listaAgentes");
        listaPolicias.getTransforms()
                .setAll(new Rotate(anguloRotacion, listaPolicias.getWidth() / 2, listaPolicias.getHeight() / 2));
        agregar(listaPolicias, 0.53, 0.63);

        setRadio(juego.getRadio());
        setControlador(controlador);

        setTarjetasVisible(true);
    }

    public void setControlador(PoliciaControlador controlador) {
        if (null == controlador) {
            return;
        }

        botonNuevo.setOnMouseClicked(controlador::botonNuevoClicked);
        botonNuevo.setOnKeyPressed(controlador::botonNuevoKeyPressed);
        listaPolicias.setOnMouseClicked(ev -> {
            Policia policiaSeleccionado = listaPolicias.getSelectionModel().getSelectedItem();
            controlador.listaPoliciasClicked(ev, policiaSeleccionado);
        });
        listaPolicias.setOnKeyPressed(ev -> {
            Policia policiaSeleccionado = listaPolicias.getSelectionModel().getSelectedItem();
            controlador.listaPoliciasKeyPressed(ev, policiaSeleccionado);
        });
        controlador.bindNombreProperty(nombreNuevo.textProperty());
        this.controlador = controlador;
    }

}
