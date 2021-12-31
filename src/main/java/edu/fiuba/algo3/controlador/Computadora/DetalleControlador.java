package edu.fiuba.algo3.controlador.Computadora;

import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class DetalleControlador {
    private final String tipo;
    private final Mision mision;
    private final List<String> posiblesValores;

    public DetalleControlador(String tipo, Mision mision) {
        this.tipo = tipo;
        this.mision = mision;
        posiblesValores = List.copyOf(mision.getValoresDeDetalleTipo(tipo));
    }

    public void onKeyPressed(KeyEvent event) {
        System.out.println(tipo + ":" + event);
        switch(event.getCode()) {
            case ENTER: case SPACE: case RIGHT:
                elegirSiguiente();
                break;
            case ESCAPE:
                elegir(-1);
            case BACK_SPACE: case LEFT:
                elegirAnterior();
        }
    }

    public void onMouseClicked(MouseEvent event) {
        System.out.println(tipo + ":" + event);
        switch(event.getButton().ordinal()) {
            case 1:
                elegirSiguiente();
                break;
            case 2: case 3:
                elegirAnterior();
        }

    }

    private int ordenActual() {
        String actualValor = mision.getDetalle(tipo);
        int actual;
        if((null==actualValor) || ("".equals(actualValor.trim())) ) {
            actual = -1;
        } else {
            actual = posiblesValores.indexOf(actualValor);
        }
        System.out.println("actual: "+actual+"="+actualValor);
        return actual;
    }

    private void elegir(int posicion) {
        // +1 para el null:
        final int rango = (posiblesValores.size()+1);
        final int ultimo = rango-1;
        // +rango por si es -1 hacerlo positivo:
        posicion = (posicion+rango) % rango;
        String nuevoValor = null;
        if(posicion< ultimo) {
            nuevoValor = posiblesValores.get(posicion);
        }
        System.out.println("ahora: "+posicion+"="+nuevoValor);
        mision.agregarDetalleLadron(tipo, nuevoValor);
    }

    private void elegirAnterior() {
        elegir(ordenActual() -1);
    }

    private void elegirSiguiente() {
        elegir(ordenActual() + 1);
    }
}
