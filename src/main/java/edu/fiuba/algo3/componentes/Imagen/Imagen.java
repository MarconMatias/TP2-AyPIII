package edu.fiuba.algo3.componentes.Imagen;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import java.io.File;
import java.net.MalformedURLException;

public class Imagen extends ImageView {
    private final DoubleProperty angulo = new SimpleDoubleProperty(0.0);

    public Imagen(String path) {
        super(path);
        Rotate rotacionEfecto = new Rotate();
        rotacionEfecto.pivotXProperty().bind(fitWidthProperty().divide(2));
        rotacionEfecto.pivotYProperty().bind(fitHeightProperty().divide(2));
        rotacionEfecto.angleProperty().bind(angulo);
        this.getTransforms().setAll(rotacionEfecto);
    }

    public DoubleProperty anguloProperty() {
        return angulo;
    }

    public final double getAngulo() {
        return anguloProperty().get();
    }

    public final void setAngulo(double nuevoAngulo) {
        anguloProperty().set(nuevoAngulo);
    }

    public static String urlDesdePath(String absoluta) {
        try {
            return (new File(absoluta)).toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Imposible crear ruta de archivo desde: "+absoluta);
        }
    }

    public static String urlDesdeRecursos(String recurso) {
        return urlDesdePath("src/main/java/edu/fiuba/algo3/recursos/"+recurso);
    }
}
