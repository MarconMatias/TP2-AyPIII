package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.controlador.Edificio.EdificiosControlador;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Edificios extends Pantalla {
    private final Librito librito;
    private final List<DestinoEdificio> destinos = new ArrayList<>();
    private final static Point2D origen = new Point2D(0.5, 0.5);
    private final ObjectProperty<DestinoEdificio> destinoElegido = new SimpleObjectProperty<>(null);
    private final ObjectProperty<DestinoEdificio> destinoSeleccionado = new SimpleObjectProperty<>(null);
    private final DoubleProperty progreso = new SimpleDoubleProperty(0d);

    public Edificios(Juego juego, Mision mision, EdificiosControlador controlador) {
        /** \todo Poner nombres de imágenes correctas cuando estén disponibles. **/
        super("src/main/java/edu/fiuba/algo3/recursos/Edificio/PlanoEdificios.jpeg");

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);

        agregarDestinos(mision.getCiudadActual().obtenerEdificios());
        agregarTrayectos();

        setRadio(juego.getRadio());
        setControlador(controlador);
        destinos.get(0).requestFocus();

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

    private void setControlador(EdificiosControlador controlador) {
        if(null == controlador) {
            return;
        }
        librito.setOnMouseClicked(controlador::libritoClicked);
        librito.setOnKeyPressed(controlador::libritoKeyPressed);
        destinoElegido.addListener(ev->controlador.destinoElegido(destinoElegido.get()));
    }
}
