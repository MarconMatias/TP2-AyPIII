package edu.fiuba.algo3.vista.Edificio.Testigo;

import edu.fiuba.algo3.componentes.Imagen.IconoEdificios;
import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.controlador.Edificio.Testigo.TestigoControlador;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import edu.fiuba.algo3.vista.Computadora.IconoOrden;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Testigo extends Pantalla {
    private final static Image[] fondos = {
            new Image(Imagen.urlDesdeRecursos("Edificio/Testigo/fondo_0.jpeg")),
            new Image(Imagen.urlDesdeRecursos("Edificio/Testigo/fondo_1.jpeg")),
            new Image(Imagen.urlDesdeRecursos("Edificio/Testigo/fondo_2.jpeg")),
            new Image(Imagen.urlDesdeRecursos("Edificio/Testigo/fondo_3.jpeg")),
            new Image(Imagen.urlDesdeRecursos("Edificio/Testigo/fondo_4.jpeg"))
    };
    private final Librito librito;
    private final IconoEdificios edificios;
    private final IconoOrden orden;
    private final String testigo;

    public Testigo(Juego juego, Mision mision,
                   String testigo, String testimonio,
                   TestigoControlador controlador) {
        super(getFondo(testigo));
        this.testigo = testigo;

        Label nombreTestigo = new Label(testigo);
        nombreTestigo.setAlignment(Pos.CENTER);
        nombreTestigo.setMaxWidth(960);
        nombreTestigo.setStyle("-fx-font: 120 Impact");
        nombreTestigo.getStyleClass().add("etiquetaNombreTestigo");
        agregar(nombreTestigo, 0.81, 0.3);

        Label burbuja = new Label(testimonio);
        burbuja.setWrapText(true);
        burbuja.setStyle("-fx-font: 100 \"Arial\"");
        burbuja.setMinWidth(1024);
        burbuja.setMaxWidth(2600);
        burbuja.setMinHeight(512);
        burbuja.setMaxHeight(800);
        burbuja.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        burbuja.getStyleClass().add("burbujaTestimonio");
        agregar(burbuja, 0.575, 0.75);

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);
        edificios = new IconoEdificios(640);
        agregar(edificios, 0.08, 0.5);
        orden = new IconoOrden(480);
        agregar(orden, 0.08, 0.6);

        setCalendario(mision.getCalendario());
        setRadio(juego.getRadio());
        setRelojVisible(true);
        iniciarControlador(controlador);
    }

    @Override
    protected void iniciarControlador(PantallaControlador controlador) {
        super.iniciarControlador(controlador);
        if(null == controlador) {
            return;
        }
        observadorAccionesProperty().bind(controlador.getObservadorLiberable());
        librito.setOnMouseClicked(controlador::libritoClicked);
        librito.setOnKeyPressed(controlador::libritoKeyPressed);
        edificios.setOnMouseClicked(controlador::edificiosClicked);
        edificios.setOnKeyPressed(controlador::edificiosKeyPressed);
        orden.setOnMouseClicked(controlador::ordenClicked);
        orden.setOnKeyPressed(controlador::ordenKeyPressed);
    }

    private static Image getFondo(String testigo) {
        int numero = Math.abs(testigo.hashCode());
        return fondos[numero % fondos.length];
    }

    @Override
    public String getTitulo() {
        return "Testimonio de "+testigo;
    }
}
