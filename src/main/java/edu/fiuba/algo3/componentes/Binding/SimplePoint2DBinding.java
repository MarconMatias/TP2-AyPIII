package edu.fiuba.algo3.componentes.Binding;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;

public class SimplePoint2DBinding extends Point2DBindingXY {

    private final DoubleProperty x;
    private final DoubleProperty y;

    /**
     * Crea un binding a un punto 2D formado por las propiedades modificables dadas.
     * @param x Propiedad que define el componente x del punto 2D.
     * @param y Propiedad que define el componente x del punto 2D.
     */
    public SimplePoint2DBinding(SimpleDoubleProperty x, SimpleDoubleProperty y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    /**
     * Crea un binding a un punto 2D formado por dos propiedades modificables iniciadas en 0d.
     */
    public SimplePoint2DBinding() {
        this(new SimpleDoubleProperty(0d), new SimpleDoubleProperty(0d));
    }

    /**
     * Crea un binding a un punto 2D formado por dos propiedades modificables iniciadas en los valores dados.
     * @param xInicial Valor inicial de la propiedad que define el componente x del punto 2D.
     * @param yInicial Valor inicial de la propiedad que define el componente y del punto 2D.
     */
    public SimplePoint2DBinding(double xInicial, double yInicial) {
        this();
        set(xInicial, yInicial);
    }

    public SimplePoint2DBinding(Point2D punto) {
        this(punto.getX(), punto.getY());
    }

    public SimplePoint2DBinding(DoubleBinding nuevoX, DoubleBinding nuevoY) {
        this();
        x.bind(nuevoX);
        y.bind(nuevoY);
    }

    public void bind(Point2DBindingXY observable) {
        x.bind(observable.xProperty());
        y.bind(observable.yProperty());
    }
    public void set(double nuevoX, double nuevoY) {
        x.set(nuevoX);
        y.set(nuevoY);
    }

    public void set(Point2D nueva) {
        set(nueva.getX(), nueva.getY());
    }
}
