package edu.fiuba.algo3.controlador.Orden;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class SospechososControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;
    private List<Runnable> liberadores = new ArrayList<>();

    public SospechososControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super();
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public void clicked(MouseEvent ev, Ladron seleccionado) {
        if(ev.isConsumed()) {
            return;
        }
        if(controlStage.abrirExpediente(juego, mision, seleccionado))
        {
            ev.consume();
            liberar();
        }
    }

    public void keyPressed(KeyEvent ev, Ladron seleccionado) {
        if(ev.isConsumed()) {
            return;
        }
        switch(ev.getCode()) {
            case ENTER: case SPACE:
                if(controlStage.abrirExpediente(juego, mision, seleccionado))
                {
                    ev.consume();
                    liberar();
                }
        }
    }

    private void liberar() {
        for(Runnable liberador : liberadores) {
            liberador.run();
        }
    }
}
