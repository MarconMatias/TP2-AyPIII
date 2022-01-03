package edu.fiuba.algo3.vista.Calendario;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.binding.StringBinding;
import javafx.scene.control.Label;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

import static javafx.beans.binding.Bindings.createStringBinding;

public class TextoRelojDia extends TextoReloj {
    public TextoRelojDia(IntegerExpression diaSemana, Label primera, Label segunda, Label tercera) {
        super(primera,segunda,tercera);
        StringBinding inicial = createStringBinding(()-> getInicial(diaSemana),diaSemana);
        primera.textProperty().bind(createStringBinding(()->inicial.get().substring(0,1),inicial));
        segunda.textProperty().bind(createStringBinding(()->inicial.get().substring(1,2),inicial));
        tercera.textProperty().bind(createStringBinding(()->inicial.get().substring(2,3),inicial));
    }

    private String getInicial(IntegerExpression diaSemana) {
        int num = diaSemana.intValue();
        return DayOfWeek.of((0==num)?7:num)
                .getDisplayName(TextStyle.SHORT,Locale.getDefault())
                .substring(0,3).toUpperCase();
    }

    public TextoRelojDia(IntegerExpression diaSemana) {
        this(diaSemana, new Label("A"), new Label("B"), new Label("C"));
    }
}
