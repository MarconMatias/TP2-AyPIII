package edu.fiuba.algo3.vista.Mapa;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.componentes.Mapamundi.Mapamundi;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.componentes.bindings.AnguloDeDestinoBinding;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.controlador.Mapa.MapaDestinosControlador;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Ciudad.DestinoCiudad;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.createStringBinding;

public class MapaDestinos extends Mapamundi {
    private final Juego juego;
    private final Mision mision;
    private final MapaDestinosControlador controlador;
    private final Librito librito;
    private final List<DestinoCiudad> destinos = new ArrayList<>();
    private final Ciudad actual;
    private final Point2D origen;
    private final ObjectProperty<DestinoCiudad> destinoSeleccionado = new SimpleObjectProperty<>(null);
    private final DoubleProperty progreso = new SimpleDoubleProperty(0d);
    private final ObjectProperty<DestinoCiudad> destinoElegido = new SimpleObjectProperty<>(null);

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

        Label etiquetaDestino = new Label();
        etiquetaDestino.textProperty().bind(createStringBinding(this::getNombreDestino, destinoSeleccionado));
        etiquetaDestino.setAlignment(Pos.CENTER);
        etiquetaDestino.setMaxWidth(960);
        etiquetaDestino.setStyle("-fx-font: 60 Impact");
        etiquetaDestino.getStyleClass().add("etiquetaDestinoSeleccionado");
        agregar(etiquetaDestino, 0.500, 0.8);

        setCalendario(mision.getCalendario());
        setRelojVisible(true);
        setRadio(juego.getRadio());
        iniciarControlador(controlador);
        destinos.get(0).requestFocus();
    }

    private String getNombreDestino() {
        Destino destino = destinoSeleccionado.get();
        if(null == destino) {
            return "A seleccionar";
        }
        return destino.getNombre();
    }

    private void agregarDestinos(List<Ciudad> ciudades) {
        for(Ciudad ciudad : ciudades) {
            DestinoCiudad destino = new DestinoCiudad(ciudad);
            agregar(destino, ciudad.getCoordenadaX(), ciudad.getCoordenadaY());

            destino.focusedProperty().addListener(obs -> {
                if(destino.isFocused()) {
                    destinoSeleccionado.set(destino);
                } else if(destinoSeleccionado.get().equals(destino)) {
                    destinoSeleccionado.set(null);
                }
            });

            destino.elegidoProperty().addListener(ev -> {
                if(null != ev) {
                    destinoElegido.set(destino);
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

    @Override
    protected void iniciarControlador(PantallaControlador controlador) {
        super.iniciarControlador(controlador);
        if(null == controlador) {
            return;
        }
        observadorAccionesProperty().bind(controlador.getObservadorLiberable());
        librito.setOnMouseClicked(controlador::libritoClicked);
        librito.setOnKeyPressed(controlador::libritoKeyPressed);
        if(controlador instanceof MapaDestinosControlador) {
            destinoElegido.addListener(
                    ev -> ((MapaDestinosControlador) controlador)
                            .destinoElegido(destinoElegido.get()));
        }
    }

    @Override
    public String getTitulo() {
        return "Elija una ciudad de destino para viajar a ella";
    }
}
