package edu.fiuba.algo3.vista.Computadora;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.controlador.Computadora.DetallesControlador;
import edu.fiuba.algo3.controlador.Computadora.DocumentosControlador;
import edu.fiuba.algo3.controlador.Computadora.SospechososControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.DetallableSospechoso;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import static javafx.beans.binding.Bindings.createObjectBinding;

public class Documentos extends Pantalla {
    private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Orden/Orden_3840.jpeg"));
    protected final Label tituloHoja = new Label();
    protected final Detalles detallesPane;
    protected final Sospechosos sospechosos;
    private final Librito librito;

    public Documentos(Juego juego, Mision mision, DetallableSospechoso detallable, DocumentosControlador controlador) {
        super(fondo);

        SospechososControlador controladorSospechosos = (null == controlador)
                ? null
                : controlador.crearControladorSospechosos();
        sospechosos = new Sospechosos(juego, mision, controladorSospechosos);

        DetallesControlador controladorDetalles = (null == controlador)
                ? null
                : controlador.crearControladorDetalles();
        detallesPane = new Detalles(juego, mision, detallable, controladorDetalles);
        detallesPane.setTitulo("Información de la persona:");

        estilarTituloHoja("Orden de arresto");

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

        librito = new Librito(640);

        agregar(tituloSospechosos, 0.805, 0.330);
        agregar(sospechosos, 0.81, 0.535);
        agregar(tituloHoja, 0.400, 0.12);
        agregar(detallesPane, 0.4, 0.4);

        agregar(librito, 0.08, 0.4);
    }

    private void estilarTituloHoja(String titulo) {
        tituloHoja.setText(titulo);
        tituloHoja.setAlignment(Pos.CENTER);
        tituloHoja.setMaxWidth(960);
        tituloHoja.setStyle("-fx-font: 100 Impact");
        tituloHoja.getStyleClass().add("etiquetaTituloOrden");
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
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
