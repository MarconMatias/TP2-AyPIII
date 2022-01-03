package edu.fiuba.algo3.componentes.RelativoAImagen;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;

public class Relativo extends DoubleBinding {
    private final DoubleExpression totalContenedor;
    private final DoubleExpression centroRelativo;
    private final DoubleExpression totalContenido;

    public Relativo(DoubleExpression totalContenedor, DoubleExpression centroRelativo, DoubleExpression totalContenido) {
        super.bind(totalContenedor, centroRelativo, totalContenido);
        this.totalContenedor = totalContenedor;
        this.centroRelativo = centroRelativo;
        this.totalContenido = totalContenido;
    }

    public Relativo(DoubleExpression totalContenedor, DoubleExpression centroRelativo) {
        this(totalContenedor, centroRelativo, new ReadOnlyDoubleWrapper(0.0));
    }

    @Override
    protected double computeValue() {
        return centroRelativo.get() * totalContenedor.get() - (totalContenido.get()/2);
    }
}
