package edu.fiuba.algo3.vista.Calendario;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.binding.StringBinding;
import javafx.scene.control.Label;

import static javafx.beans.binding.Bindings.createStringBinding;

public class TextoRelojAM extends TextoReloj {
    public TextoRelojAM(IntegerExpression hora, Label primera) {
        super(primera,new Label("M"));
        StringBinding binding = createStringBinding(()-> hora.get() < 12? "A" : "P", hora);
        primera.textProperty().bind(binding);
    }

    public TextoRelojAM(IntegerExpression hora) {
        this(hora, new Label("A"));
    }
}
