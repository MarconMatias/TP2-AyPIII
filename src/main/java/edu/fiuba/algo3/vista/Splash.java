package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Mapamundi.*;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.componentes.bindings.CargandoBinding;
import edu.fiuba.algo3.componentes.bindings.Point2DBindingXY;
import edu.fiuba.algo3.componentes.bindings.SimplePoint2DBinding;
import javafx.beans.property.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class Splash extends Mapamundi {
    private final String textoFinal = "¡Listo! Presioná ENTER o hacé click para continuar";
    private final Label labelEstado;
    private DoubleProperty progreso = new SimpleDoubleProperty(0.0);
    private Point2DBindingXY desde = new SimplePoint2DBinding(0.1650, 0.3390);
    private Point2DBindingXY hasta = new SimplePoint2DBinding(0.8460, 0.7660);

    public Splash() {
        labelEstado = new Label("Cargando");
        labelEstado.prefWidthProperty().bind(nuevoXRelativo(0.9));
        labelEstado.setAlignment(Pos.CENTER);
        labelEstado.setStyle("-fx-font: 120 Arial");
        labelEstado.getStyleClass().add("cargandoMapamundi");
        agregar((Region) labelEstado, 0.5, 0.9);
        Imagen origen = agregar(new Destino(""), desde.xProperty(), desde.yProperty());
        Imagen destino = agregar(new Destino(""), hasta.xProperty(), hasta.yProperty());
        Trayecto trayecto = agregarTrayecto(desde, hasta);
        labelEstado.textProperty().bind(new CargandoBinding(progresoProperty(),textoFinal));
        cooordenadasAvionProperty().bind(nuevoRelativoConAbsoluto(trayecto.puntoDeProgreso(progreso)));
        anguloAvionProperty().bind(trayecto.anguloEnProgreso(progreso));
    }

    public DoubleProperty progresoProperty() {
        return progreso;
    }
}
