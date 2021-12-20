package edu.fiuba.algo3.controlador.Radio;

import edu.fiuba.algo3.modelo.Radio.Radio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RadioControlador implements EventHandler<ActionEvent> {
    private final Radio radio;

    public RadioControlador(Radio radio) {
        this.radio = radio;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
