package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.controlador.Edificio.EdificiosControlador;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.createStringBinding;

public class Edificios extends Pantalla {
    private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Edificio/PlanoEdificios.jpeg"));
    private final Librito librito;
    private final List<DestinoEdificio> destinos = new ArrayList<>();
    private final static Point2D origen = new Point2D(0.5, 0.5);
    private final ObjectProperty<DestinoEdificio> destinoElegido = new SimpleObjectProperty<>(null);
    private final ObjectProperty<DestinoEdificio> destinoSeleccionado = new SimpleObjectProperty<>(null);
    private final DoubleProperty progreso = new SimpleDoubleProperty(0d);

    public Edificios(Juego juego, Mision mision, EdificiosControlador controlador) {
        super(fondo);

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);

        agregarDestinos(mision.getCiudadActual().obtenerEdificios());
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

    private void agregarDestinos(List<Edificio> edificios) {
        for(Edificio edificio : edificios) {
            DestinoEdificio destino = DestinoEdificio.crear(edificio);
            agregar(destino, destino.getCoordenadas().getX(), destino.getCoordenadas().getY());

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
        for(DestinoEdificio destino : destinos) {
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
        if(controlador instanceof EdificiosControlador) {
            destinoElegido.addListener(
                    ev -> {
                            ((EdificiosControlador) controlador)
                                    .destinoElegido(destinoElegido.get());

                    });
        }
    }

    @Override
    public String getTitulo() {
        return "Elija edificios para obtener testimonios";
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
