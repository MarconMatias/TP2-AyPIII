package edu.fiuba.algo3.componentes.bindings;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Point2D;

public class Point2DBindingXY extends ObjectBinding<Point2D> {
    private final DoubleExpression x;
    private final DoubleExpression y;

    public Point2DBindingXY(DoubleExpression x, DoubleExpression y) {
        this.x = x;
        this.y = y;
        this.bind(x,y);
    }

    /**
     * Devuelve un nuevo binding cuyo valor resulta de la sumatoria de éste y `sumando`.
     * @param sumando Binding del valor a sumar.
     * @return
     */
    public Point2DBindingXY add(Point2DBindingXY sumando) {
        DoubleBinding nuevoX = xProperty().add(sumando.xProperty());
        DoubleBinding nuevoY = yProperty().add(sumando.yProperty());
        return new SimplePoint2DBinding(nuevoX, nuevoY);
    }

    @Override
    protected Point2D computeValue() {
        return new Point2D(x.get(), y.get());
    }


    /**
     * Devuelve un nuevo binding cuyo valor resulta dl producto de éste y `factor`.
     * @param factor Binding del punto con los componentes para multiplicar.
     * @return Un binding donde cada componente es el producto del mismo componenente de éste y de `factor`.
     */
    public Point2DBindingXY multiply(Point2DBindingXY factor) {
        DoubleBinding nuevoX = xProperty().multiply(factor.xProperty());
        DoubleBinding nuevoY = yProperty().multiply(factor.yProperty());
        return new SimplePoint2DBinding(nuevoX, nuevoY);
    }

    /**
     * Devuelve un nuevo binding cuyo valor resulta dl producto de éste y `factor`.
     * @param factor Binding del valor a multiplicar.
     * @return
     */
    public Point2DBindingXY multiply(ReadOnlyDoubleProperty factor) {
        DoubleBinding nuevoX = xProperty().multiply(factor);
        DoubleBinding nuevoY = yProperty().multiply(factor);
        return new SimplePoint2DBinding(nuevoX, nuevoY);
    }

    /**
     * Devuelve un nuevo binding cuyo valor resulta de la sumatoria de éste y `sustraendo`.
     * @param sustraendo Binding del valor a restar.
     * @return Binding de la resta.
     */
    public Point2DBindingXY subtract(Point2DBindingXY sustraendo) {
        DoubleBinding nuevoX = xProperty().subtract(sustraendo.xProperty());
        DoubleBinding nuevoY = yProperty().subtract(sustraendo.yProperty());
        return new SimplePoint2DBinding(nuevoX, nuevoY);
    }

    public DoubleExpression xProperty() {
        return x;
    }

    public DoubleExpression yProperty() {
        return y;
    }
}
