package edu.fiuba.algo3.controlador.Computadora;

import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
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
        onElegido.accept(seleccionado);
        ev.consume();
    }

    public void keyPressed(KeyEvent ev, Ladron seleccionado) {
        if(ev.isConsumed()) {
            return;
        }
        switch(ev.getCode()) {
            case ENTER: case SPACE:
                onElegido.accept(seleccionado);
                ev.consume();
        }
    }
}
