package edu.fiuba.algo3;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.vista.Juego.GrupoInterno;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.List;

public class ControladorStage {
    private final Stage stage;
    private final GrupoInterno raiz;
    private final Scene scene;
    private final Scale escalado = new Scale();
    private final DoubleProperty escala = new SimpleDoubleProperty(1.0);
    private final DoubleProperty ancho = new SimpleDoubleProperty(1024);

    public ControladorStage(Stage stage, Parent interno) {
        this.stage = stage;
        this.raiz = new GrupoInterno(interno);
        this.scene = new Scene(raiz);
        final String pathEstilo = "src/main/java/edu/fiuba/algo3/recursos/estilos.css";
        final String url = Imagen.urlDesdePath(pathEstilo);
        scene.getStylesheets().addAll(url);
        escalado.setPivotX(0d);
        escalado.setPivotY(0d);
        escalado.xProperty().bind(escala);
        escalado.yProperty().bind(escala);
        raiz.getTransforms().setAll(escalado);
        escala.bind(new DoubleBinding() {
            {
                this.bind(stage.widthProperty(), raiz.boundsInLocalProperty());
            }
            @Override
            protected double computeValue() {
                return stage.getWidth()/raiz.getBoundsInLocal().getWidth();
            }
        });
    }

    public Point2D getCentro() {
        double x = stage.getX() + (stage.getWidth()/2);
        double y = stage.getY() + (stage.getHeight()/2);
        if(Double.isNaN(Math.max(x,y))) {
            return getCentroPantalla();
        }
        return new Point2D(x,y);
    }

    public static Point2D getCentro(Rectangle2D rect) {
        double x = (rect.getMinX() + rect.getMaxX()) / 2;
        double y = (rect.getMinY() + rect.getMaxY()) / 2;
        return new Point2D(Math.max(0,x),Math.max(0,y));
    }

    public Point2D getCentroPantalla() {
        return getCentro(getDimensionPantalla());
    }

    private static double siNaNEntonces(double talVezNaN, double reemplazo) {
        return Double.isNaN(talVezNaN) ? reemplazo : talVezNaN;
    }

    public Rectangle2D getDimensionPantalla() {
        List<Screen> screens = Screen.getScreensForRectangle(stage.getX(), stage.getY(),1, 1);
        // Si no está inicializado el stage, getX() y getY() devuelven NaN y la lista estará vacía:
        Screen screen = (screens.size()>0) ? screens.get(0) : Screen.getPrimary();
        return screen.getBounds();
    }

    public void setCentro(Point2D nuevoCentro) {
        double ancho = siNaNEntonces(stage.getWidth(), 0);
        double alto =  siNaNEntonces(stage.getHeight(), 0);
        double x = nuevoCentro.getX()-(ancho/2);
        double y = nuevoCentro.getY()-(alto/2);
        stage.setX(x);
        stage.setY(y);
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
        setCentro(getCentroPantalla());
    }

    public Scene getScene() {
        return scene;
    }

    public void cambiar(Node interno) {
        raiz.cambiar(interno);
    }
}
