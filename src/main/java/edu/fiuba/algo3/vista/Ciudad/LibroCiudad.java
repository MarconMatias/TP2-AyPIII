package edu.fiuba.algo3.vista.Ciudad;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Imagen.Mapita;
import edu.fiuba.algo3.componentes.Imagen.Tarjetas;
import edu.fiuba.algo3.componentes.Libro.Libro;
import edu.fiuba.algo3.controlador.Ciudad.LibroCiudadControlador;
import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Radio.Radio;
import edu.fiuba.algo3.vista.Radio.Walkman;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.transform.Rotate;

public class LibroCiudad extends Libro {
    private final Mapita mapita;

    public LibroCiudad(Juego juego, Mision mision) {
        super();

        Ciudad ciudad = mision.getCiudadActual();
        Label tituloCiudad = new Label();
        tituloCiudad.setText(ciudad.getNombre());
        tituloCiudad.setAlignment(Pos.CENTER);
        tituloCiudad.setMaxWidth(960);
        tituloCiudad.setMaxHeight(384);
        tituloCiudad.setWrapText(true);
        tituloCiudad.setStyle("-fx-font: 120 Impact");
        tituloCiudad.getStyleClass().add("etiquetaTituloLibroCiudad");
        tituloCiudad.getTransforms().setAll(new Rotate(2d, 0,0));
        agregar(tituloCiudad, 0.368, 0.225);

        FotoCiudad fotoCiudad = new FotoCiudad(ciudad);
        fotoCiudad.anguloProperty().set(1d);
        agregar(fotoCiudad, 0.368, 0.41);

        Label textoCiudad = new Label();
        textoCiudad.setAlignment(Pos.CENTER);
        textoCiudad.setText(/*ciudad.getDetalles()*/"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
        textoCiudad.setMaxWidth(960);
        textoCiudad.setMaxHeight(576);
        textoCiudad.setWrapText(true);
        textoCiudad.setStyle("-fx-font: 60 \"Times New Roman\"");
        textoCiudad.getStyleClass().add("etiquetaTextoLibroCiudad");
        agregar(textoCiudad, 0.368, 0.675);

        mapita = new Mapita(640);
        agregar(mapita, 0.08, 0.4);

        setRadio(juego.getRadio());
        ponerTarjetas();
    }

    private void ponerTarjetas() {
        Tarjetas tarjetas = new Tarjetas(640);
        agregar(tarjetas, 0.9, 0.9);
    }

    public LibroCiudad(Juego juego, Mision mision, LibroCiudadControlador controlador) {
        this(juego, mision);
        setControlador(controlador);
    }

    private void setControlador(LibroCiudadControlador controlador) {
        if(null == controlador) {
            return;
        }
        mapita.setOnMouseClicked(controlador::mapitaClicked);
        mapita.setOnKeyPressed(controlador::mapitaKeyPressed);
    }

    public void setRadio(Radio radio) {
        try {
            Walkman walkman = new Walkman(new RadioControlador(radio));
            agregar((Imagen) walkman, 0.026, 0.285);
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "Error al crear la radio, es posible que la escuche pero no pueda controlarla.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
