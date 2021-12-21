package edu.fiuba.algo3.vista.Mapa;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.componentes.Mapamundi.Mapamundi;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.componentes.bindings.AnguloDeDestinoBinding;
import edu.fiuba.algo3.controlador.Mapa.MapaDestinosControlador;
import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Radio.Radio;
import edu.fiuba.algo3.vista.Ciudad.DestinoCiudad;
import edu.fiuba.algo3.vista.Radio.Walkman;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.List;

public class MapaDestinos extends Mapamundi {
    private final Juego juego;
    private final Mision mision;
    private final MapaDestinosControlador controlador;
    private final Librito librito;
    private final List<DestinoCiudad> destinos = new ArrayList<>();
    private final Ciudad actual;
    private final Point2D origen;
    private final ObjectProperty<DestinoCiudad> destinoSeleccionado = new SimpleObjectProperty<>();
    private final DoubleProperty progreso = new SimpleDoubleProperty(0d);

    public MapaDestinos(Juego juego, Mision mision, MapaDestinosControlador controlador)
    {
        super();
        this.juego = juego;
        this.mision = mision;
        this.controlador = controlador;

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);

        actual = mision.getCiudadActual();
        origen = new Point2D(actual.getCoordenadaX(), actual.getCoordenadaY());
        cooordenadasAvionProperty().set(actual.getCoordenadaX(), actual.getCoordenadaY());
        anguloAvionProperty().bind(new AnguloDeDestinoBinding(destinoSeleccionado, progreso));
        agregarDestinos(mision.getCiudadesVecinas());
        agregarTrayectos();

        setRadio(juego.getRadio());
        setControlador(controlador);
        destinos.get(0).requestFocus();
    }

    private void agregarDestinos(List<Ciudad> ciudades) {
        for(Ciudad ciudad : ciudades) {
            DestinoCiudad destino = new DestinoCiudad(ciudad);
            agregar(destino, ciudad.getCoordenadaX(), ciudad.getCoordenadaY());

            destino.focusedProperty().addListener(obs -> {
                if(destino.isFocused()) {
                    destinoSeleccionado.set(destino);
                } else if(destinoSeleccionado.equals(destino)) {
                    destinoSeleccionado.set(null);
                }
            });

            destinos.add(destino);
        }
    }

    private void agregarTrayectos() {
        for(DestinoCiudad destino : destinos) {
            Trayecto trayecto = agregarTrayecto(origen, destino.getCoordenadas());
            destino.setTrayecto(trayecto);
        }
    }

    private void setControlador(MapaDestinosControlador controlador) {
        if(null == controlador) {
            return;
        }
        librito.setOnMouseClicked(controlador::libritoClicked);
        librito.setOnKeyPressed(controlador::libritoKeyPressed);
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
