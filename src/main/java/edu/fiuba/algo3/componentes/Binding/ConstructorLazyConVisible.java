package edu.fiuba.algo3.componentes.Binding;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.Node;

import java.util.function.Supplier;

public class ConstructorLazyConVisible<T extends Node> extends ObjectBinding<T> {
    private final Supplier<T> constructor;
    private final BooleanExpression visible;
    private T instancia;

    public ConstructorLazyConVisible(Supplier<T> constructor, BooleanExpression visible) {
        super();
        this.bind(visible);
        this.constructor = constructor;
        this.visible = visible;
    }

    @Override
    protected T computeValue() {
        return visible.get() ? computeVisible() : computeInvisible();
    }

    private T computeInvisible() {
        if(null != instancia) {
            instancia.setVisible(false);
        }
        return instancia;
    }

    private T computeVisible() {
        evaluarInstancia().setVisible(true);
        return instancia;
    }

    @Override
    protected void onInvalidating() {
        super.onInvalidating();
        // Esto es necesario porque se inicia inválida, al cambiar visible a true como
        // ya es inválida no vuelve a evaluar nada.
        evaluarInstancia();
    }

    private T evaluarInstancia() {
        if( (null == instancia) && visible.get() ) {
            instancia = constructor.get();
        }
        return instancia;
    }
}
