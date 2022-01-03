package edu.fiuba.algo3.controlador.Computadora;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SospechososControlador {
    private final Juego juego;
    private final Mision mision;
    private final Consumer<Ladron> onElegido;
    private List<Runnable> liberadores = new ArrayList<>();

    public SospechososControlador(Juego juego, Mision mision, Consumer<Ladron> onElegido) {
        super();
        this.juego = juego;
        this.mision = mision;
        this.onElegido = onElegido;
    }

    public void clicked(MouseEvent ev, Ladron seleccionado) {
        if(ev.isConsumed()) {
            return;
        }
        seleccionar(ev,seleccionado);
    }

    public void keyPressed(KeyEvent ev, Ladron seleccionado) {
        if(ev.isConsumed()) {
            return;
        }
        switch(ev.getCode()) {
            case ENTER: case SPACE:
                seleccionar(ev,seleccionado);
        }
    }

    private void seleccionar(InputEvent ev, Ladron seleccionado) {
        try {
            onElegido.accept(seleccionado);
            ev.consume();
        } catch(Exception ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alerta.showAndWait();
        }
    }

}
