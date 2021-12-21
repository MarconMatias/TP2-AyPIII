package edu.fiuba.algo3.componentes.Mapamundi;

import edu.fiuba.algo3.componentes.Imagen.Avion;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.componentes.bindings.SimplePoint2DBinding;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point2D;

public class Mapamundi extends RelativoAImagen {
    private final Avion avion = new Avion();
    private final SimplePoint2DBinding cooordenadasAvion = new SimplePoint2DBinding(0.5,0.5);

    public Mapamundi() {
        super("src/main/java/edu/fiuba/algo3/recursos/Mapa/MapaAlgoThief_3840.jpeg");
        agregar(avion, cooordenadasAvion.xProperty(), cooordenadasAvion.yProperty());
    }

    public DoubleProperty anguloAvionProperty() {
        return avion.anguloProperty();
    }

    public SimplePoint2DBinding cooordenadasAvionProperty() {
        return cooordenadasAvion;
    }

    public Point2D getCooordenadasAvion() {
        return cooordenadasAvion.get();
    }

    public void setCoordenadasAvion(Point2D nueva) {
        cooordenadasAvion.set(nueva);
    }
}
