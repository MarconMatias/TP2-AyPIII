package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.componentes.Imagen.Logo;
import edu.fiuba.algo3.componentes.Mapamundi.Mapamundi;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.componentes.bindings.CargandoBinding;
import edu.fiuba.algo3.componentes.bindings.Point2DBindingXY;
import edu.fiuba.algo3.componentes.bindings.SimplePoint2DBinding;
import edu.fiuba.algo3.controlador.Splash.SplashControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class Splash extends Mapamundi {
    private final String textoFinal = "¡Listo! Presioná ENTER o hacé click para continuar";
    private final Label labelEstado;
    private DoubleProperty progreso = new SimpleDoubleProperty(0.0);
    private Point2DBindingXY desde = new SimplePoint2DBinding(0.1650, 0.3390);
    private Point2DBindingXY hasta = new SimplePoint2DBinding(0.8460, 0.7660);

    public Splash(Juego juego, SplashControlador controlador) {
        Logo logo = new Logo(1728d);
        agregar(logo, 0.5, 0.172);
        labelEstado = new Label("Cargando");
        labelEstado.prefWidthProperty().bind(nuevoXRelativo(0.9));
        labelEstado.setAlignment(Pos.CENTER);
        labelEstado.setStyle("-fx-font: 120 Arial");
        labelEstado.getStyleClass().add("cargandoMapamundi");
        agregar((Region) labelEstado, 0.5, 0.9);

        Destino origen = new Destino("");
        origen.setWidth(96);
        agregar(origen, desde.xProperty(), desde.yProperty());

        Destino destino = new Destino("");
        destino.setWidth(96);
        agregar(destino, hasta.xProperty(), hasta.yProperty());

        Trayecto trayecto = agregarTrayecto(desde, hasta);
        labelEstado.textProperty().bind(new CargandoBinding(progresoProperty(),textoFinal));
        cooordenadasAvionProperty().bind(nuevoRelativoConAbsoluto(trayecto.puntoDeProgreso(progreso)));
        anguloAvionProperty().bind(trayecto.anguloEnProgreso(progreso));

        controlador.enlazar(this);
        setRadio(juego.getRadio());
        setFocusTraversable(true);
    }

    public DoubleProperty progresoProperty() {
        return progreso;
    }
}
