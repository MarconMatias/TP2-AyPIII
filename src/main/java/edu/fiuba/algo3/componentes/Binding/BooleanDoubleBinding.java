package edu.fiuba.algo3.componentes.Binding;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.ReadOnlyDoubleWrapper;

public class BooleanDoubleBinding extends DoubleBinding {

    private final BooleanExpression booleanCondition;
    private final DoubleExpression doubleIfTrue;
    private final DoubleExpression doubleIfFalse;

    public BooleanDoubleBinding(BooleanExpression booleanCondition,
                                DoubleExpression doubleIfTrue,
                                DoubleExpression doubleIfFalse) {
        this.bind(booleanCondition, doubleIfTrue, doubleIfFalse);
        this.booleanCondition = booleanCondition;
        this.doubleIfTrue = doubleIfTrue;
        this.doubleIfFalse = doubleIfFalse;
    }

    public BooleanDoubleBinding(BooleanExpression booleanCondition,
                                double doubleIfTrue,
                                double doubleIfFalse) {
        this(booleanCondition,
                new ReadOnlyDoubleWrapper(doubleIfTrue),
                new ReadOnlyDoubleWrapper(doubleIfFalse));
    }

    @Override
    protected double computeValue() {
        if(booleanCondition.get()) {
            return doubleIfTrue.get();
        } else {
            return doubleIfFalse.get();
        }
    }
}
