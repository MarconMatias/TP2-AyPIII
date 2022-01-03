package edu.fiuba.algo3.componentes.Mapamundi;

import edu.fiuba.algo3.componentes.Binding.SimplePoint2DBinding;
import edu.fiuba.algo3.componentes.Imagen.Avion;
import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Mapamundi extends Pantalla {
    private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Mapa/MapaAlgoThief_3840.jpeg"));
    private final Avion avion = new Avion();
    private final SimplePoint2DBinding cooordenadasAvion = new SimplePoint2DBinding(0.5,0.5);

    public Mapamundi() {
        //super("src/main/java/edu/fiuba/algo3/recursos/Mapa/MapaAlgoThief_3840.jpeg");
        super(fondo);
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
