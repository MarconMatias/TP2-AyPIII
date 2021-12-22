package edu.fiuba.algo3.componentes.RelativoAImagen;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.componentes.bindings.Point2DBindingXY;
import edu.fiuba.algo3.componentes.bindings.SimplePoint2DBinding;
import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import edu.fiuba.algo3.modelo.Radio.Radio;
import edu.fiuba.algo3.vista.Radio.Walkman;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

public class RelativoAImagen extends Group {
    private final Image fondo;
    private final ImageView imageView;
    private Walkman walkman = null;

    public RelativoAImagen(Image imagen) {
        this.fondo = imagen;
        double w = imagen.getWidth();
        double h = imagen.getHeight();
        imageView = new ImageView(imagen);
        imageView.setFitWidth(w);
        imageView.setFitHeight(h);
        imageView.setViewOrder(0);
        imageView.viewportProperty().set(new Rectangle2D(0, 0, fondo.getWidth(), fondo.getHeight()));
        this.getChildren().add(imageView);

        Rectangle clip = new Rectangle(0, 0, 10, 10);
        clip.widthProperty().bind(imagen.widthProperty());
        clip.heightProperty().bind(imagen.heightProperty());
        setClip(clip);
    }

    public RelativoAImagen(String path) {
        this(new Image(Imagen.urlDesdePath(path)));
    }

    public Point2DBindingXY nuevoRelativoConAbsoluto(Point2DBindingXY absoluto) {
        DoubleBinding x = absoluto.xProperty().divide(fondo.getWidth());
        DoubleBinding y = absoluto.yProperty().divide(fondo.getHeight());
        return new Point2DBindingXY(x, y);
    }

    /**
     * Genera un binding para las coordenadas absolutas del valor relativo dado por centroRelativo.
     *
     * @param centroRelativo Coordenadas relativas, entre 0.0 y 1.0, del centro del punto.
     * @param totalContenido Ancho (absoluto) de la imagen a centrar (0.0 para no centrar).
     * @return Un binding para las coordenadas ABSOLUTAS del punto relativo.
     */
    public DoubleBinding nuevoXRelativo(DoubleExpression centroRelativo, DoubleExpression totalContenido) {
        return new Relativo(fondo.widthProperty(), centroRelativo, totalContenido);
    }

    /**
     * Genera un binding para las coordenadas absolutas del valor relativo dado.
     *
     * @param posicion Coordenadas relativas, entre 0.0 y 1.0, del centro del punto.
     * @return Un binding para las coordenadas ABSOLUTAS del punto relativo dado.
     */
    public DoubleBinding nuevoXRelativo(DoubleExpression posicion) {
        return nuevoXRelativo(posicion, new ReadOnlyDoubleWrapper(0.0));
    }

    /**
     * Genera un binding para las coordenadas absolutas del valor relativo dado.
     *
     * @param posicion Coordenadas relativas, entre 0.0 y 1.0, del centro del punto.
     * @return Un binding para las coordenadas ABSOLUTAS del punto relativo dado.
     */
    public DoubleBinding nuevoXRelativo(double posicion) {
        return nuevoXRelativo(new ReadOnlyDoubleWrapper(posicion), new ReadOnlyDoubleWrapper(0.0));
    }

    /**
     * Genera un binding para las coordenadas absolutas del valor relativo dado por centroRelativo.
     *
     * @param centroRelativo Coordenadas relativas, entre 0.0 y 1.0, del centro del punto.
     * @param totalContenido Alto (absoluto) de la imagen a centrar (0.0 para no centrar).
     * @return Un binding para las coordenadas ABSOLUTAS del punto relativo.
     */
    public DoubleBinding nuevoYRelativo(DoubleExpression centroRelativo, DoubleExpression totalContenido) {
        return new Relativo(fondo.heightProperty(), centroRelativo, totalContenido);
    }

    /**
     * Genera un binding para las coordenadas absolutas del valor relativo dado.
     *
     * @param posicion Coordenadas relativas, entre 0.0 y 1.0, del centro del punto.
     * @return Un binding para las coordenadas ABSOLUTAS del punto relativo dado.
     */
    public DoubleBinding nuevoYRelativo(DoubleExpression posicion) {
        return nuevoYRelativo(posicion, new ReadOnlyDoubleWrapper(0.0));
    }

    /**
     * Genera un binding para las coordenadas absolutas del valor relativo dado.
     *
     * @param relativo Coordenadas relativas, entre 0.0 y 1.0 cada componente, del centro del punto.
     * @return Un binding para las coordenadas ABSOLUTAS del punto relativo dado.
     */
    private Point2DBindingXY nuevoRelativo(Point2DBindingXY relativo) {
        DoubleBinding x = nuevoXRelativo(relativo.xProperty());
        DoubleBinding y = nuevoYRelativo(relativo.yProperty());
        return new SimplePoint2DBinding(x, y);
    }

    /**
     * Agrega el nodo dado centrado en las coordenadas relativas dadas usando el ancho y alto dado.
     *
     * @param nodo      Nodo a agregar.
     * @param centroX   Coordenadas relativas, entre 0.0 y 1.0 del componente X del centro del nodo.
     * @param centroY   Coordenadas relativas, entre 0.0 y 1.0 del componente Y del centro del nodo.
     * @param anchoReal Ancho (absoluto) de la imagen a centrar (0.0 para no centrar). Suele usarse widthProperty.
     * @param altoReal  Alto (absoluto) de la imagen a centrar (0.0 para no centrar). Suele usarse heightProperty.
     * @return
     */
    public Node agregar(Node nodo, DoubleExpression centroX, DoubleExpression centroY, DoubleExpression anchoReal, DoubleExpression altoReal) {
        nodo.layoutXProperty().bind(nuevoXRelativo(centroX, anchoReal));
        nodo.layoutYProperty().bind(nuevoYRelativo(centroY, altoReal));
        this.getChildren().add(nodo);
        return nodo;
    }

    /**
     * Agrega la imagen dada centrada en las coordenadas relativas dadas.
     *
     * @param nodo    Imagen  a agregar.
     * @param centroX Coordenadas relativas, entre 0.0 y 1.0 del componente X del centro de la imagen.
     * @param centroY Coordenadas relativas, entre 0.0 y 1.0 del componente Y del centro de la imagen.
     * @return
     */
    public Imagen agregar(Imagen nodo, DoubleExpression centroX, DoubleExpression centroY) {
        agregar((Node) nodo, centroX, centroY, nodo.fitWidthProperty(), nodo.fitHeightProperty());
        return nodo;
    }

    /**
     * Agrega la imagen dada centrada en las coordenadas relativas dadas.
     *
     * @param nodo    Imagen  a agregar.
     * @param centroX Coordenadas relativas, entre 0.0 y 1.0 del componente X del centro de la imagen.
     * @param centroY Coordenadas relativas, entre 0.0 y 1.0 del componente Y del centro de la imagen.
     * @return
     */
    public Imagen agregar(Imagen nodo, double centroX, double centroY) {
        agregar(nodo, new ReadOnlyDoubleWrapper(centroX), new ReadOnlyDoubleWrapper(centroY));
        return nodo;
    }

    /**
     * Agrega la región dada centrada en las coordenadas relativas dadas.
     *
     * @param nodo    Región a agregar.
     * @param centroX Coordenadas relativas, entre 0.0 y 1.0 del componente X del centro de la imagen.
     * @param centroY Coordenadas relativas, entre 0.0 y 1.0 del componente Y del centro de la imagen.
     * @return
     */
    public Region agregar(Region nodo, DoubleExpression centroX, DoubleExpression centroY) {
        agregar((Node) nodo, centroX, centroY, nodo.widthProperty(), nodo.heightProperty());
        return nodo;
    }

    /**
     * Agrega la región dada centrada en las coordenadas relativas dadas.
     *
     * @param nodo    Región a agregar.
     * @param centroX Coordenadas relativas, entre 0.0 y 1.0 del componente X del centro de la imagen.
     * @param centroY Coordenadas relativas, entre 0.0 y 1.0 del componente Y del centro de la imagen.
     * @return
     */
    public void agregar(Region nodo, double centroX, double centroY) {
        agregar(nodo, new ReadOnlyDoubleWrapper(centroX), new ReadOnlyDoubleWrapper(centroY));
    }

    public Trayecto agregarTrayecto(Point2DBindingXY desdeRelativo, Point2DBindingXY hastaRelativo) {
        Trayecto trayecto = new Trayecto(nuevoRelativo(desdeRelativo), nuevoRelativo(hastaRelativo));
        this.getChildren().add(trayecto);
        return trayecto;
    }

    public Trayecto agregarTrayecto(Point2D desdeRelativo, Point2D hastaRelativo) {
        return agregarTrayecto(new SimplePoint2DBinding(desdeRelativo), new SimplePoint2DBinding(hastaRelativo));
    }

    public Point2D absolutoConRelativo(Point2D relativo) {
        double x = relativo.getX() * fondo.getWidth();
        double y = relativo.getY() * fondo.getHeight();
        return new Point2D(x,y);
    }

    protected void setRadio(Radio radio) {
        if(null != walkman) {
            getChildren().remove(walkman);
            /* \todo liberar walkman anterior para que se desuscriba. */
        }
        if(null == radio) {
            walkman = null;
            return;
        }
        try {
            walkman = new Walkman(new RadioControlador(radio));
            agregar((Imagen) walkman, 0.026, 0.285);
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "Error al crear la radio, es posible que la escuche pero no pueda controlarla.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
