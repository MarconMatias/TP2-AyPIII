package edu.fiuba.algo3.componentes.Trayecto;

import edu.fiuba.algo3.componentes.bindings.Point2DBindingXY;
import edu.fiuba.algo3.componentes.bindings.SimplePoint2DBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Trayecto extends Line {
    private static double viewOrder = -10;
    private final Point2DBindingXY desde;
    private final Point2DBindingXY hasta;

    public Trayecto(Point2DBindingXY desde, Point2DBindingXY hasta) {
        this.setViewOrder(viewOrder);
        this.desde = desde;
        this.hasta = hasta;
        setStroke(Color.valueOf("#202020A0"));
        setStrokeWidth(16);
        this.getStrokeDashArray().addAll(40d);

        startXProperty().bind(desde.xProperty());
        startYProperty().bind(desde.yProperty());
        endXProperty().bind(hasta.xProperty());
        endYProperty().bind(hasta.yProperty());
    }

    public Trayecto(Point2D desde, Point2D hasta) {
        this(new SimplePoint2DBinding(desde), new SimplePoint2DBinding(hasta));
    }

    public double getWidth() {
        Bounds inLocal = getBoundsInLocal();
        return inLocal.getWidth();
    }

    public double getHeight() {
        Bounds inLocal = getBoundsInLocal();
        return inLocal.getHeight();
    }

    /**
     * Genera un binding a coordenadas ABSOLUTAS dentro del trayecto, que corresponden
     * al progreso dado.
     * @param progreso Valor entre 0.0 y 1.0 indicando el progreso en el trayecto.
     * @return Un binding a Point2D con las coordenadas ABSOLUTAS.
     */
    public Point2DBindingXY puntoDeProgreso(ReadOnlyDoubleProperty progreso) {
        return hasta.subtract(desde).multiply(progreso).add(desde);
    }

        public Point2D puntoDeProgreso(double progreso) {
        progreso = Math.max(0,Math.min(1.0,progreso));
        return hasta.get().subtract(desde.get()).multiply(progreso).add(desde.get());
    }

    public static double anguloConPuntos(Point2D desde, Point2D hasta) {
        Point2D dif = hasta.subtract(desde);
        return (360 + 90 + Math.atan2(dif.getY(), dif.getX()) * 180 / Math.PI) % 360;
    }

    public DoubleBinding anguloEnProgreso(ReadOnlyDoubleProperty progreso) {
        return new DoubleBinding() {
            {
                this.bind(progreso,desde,hasta);
            }

            @Override
            protected double computeValue() {
                double deltaActual = (progreso.get()>=1.0)? -1e6 : 0;
                Point2D actual = puntoDeProgreso(progreso.get() - deltaActual);
                return anguloConPuntos(actual,hasta.get());
            }
        };
    }

    public double anguloEnProgreso(double progreso) {
        final double delta = 1e-6;
        Point2D desde = puntoDeProgreso(progreso + (1.0 == progreso? -delta : 0.0) );
        Point2D hasta = puntoDeProgreso(progreso + (1.0 == progreso? 0.0 : delta) );
        return anguloConPuntos(desde,hasta);
    }
}
