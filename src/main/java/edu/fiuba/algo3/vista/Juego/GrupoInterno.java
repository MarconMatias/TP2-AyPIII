package edu.fiuba.algo3.vista.Juego;

import javafx.scene.Group;

import java.util.ArrayList;

public class GrupoInterno extends Group {
    private final ArrayList<Pantalla> pila = new ArrayList<>();

    public GrupoInterno(Pantalla pantalla) {
        super(pantalla);
        pila.add(pantalla);
    }

    /**
     * Actualiza, si es necesario, la pantalla que está mostrando con la actual.
     */
    private void actualizar() {
        Pantalla nueva = getActual();
        Pantalla vieja = (Pantalla) this.getChildren().get(0);
        if( (nueva == vieja) || (null == nueva) ) {
            return;
        }
        this.getChildren().clear();
        this.getChildren().setAll(nueva);
    }

    public void cambiar(Pantalla pantalla) {
        this.getChildren().clear();
        this.getChildren().setAll(pantalla);
    }

    /**
     * Obtener pantalla actual.
     * @return Pantalla, o null si no hay pantallas actualmente.
     */
    public Pantalla getActual() {
        int pos = pila.size()-1;
        if(pos<0) {
            return null;
        } else {
            return pila.get(pos);
        }
    }

    /**
     * Pone una pantalla abajo de la indicada como referencia.
     * @param nuevo Pantalla nueva a agregar.
     * @param referencia Pantalla actual que queda arriba de la nueva.
     * @return La pantalla que queda como actual (que puede no ser nueva ni referencia).
     */
    public Pantalla ponerAbajo(Pantalla nuevo, Pantalla referencia) {
        int pos = Math.max(0,pila.indexOf(referencia)-1);
        pila.add(pos, nuevo);
        actualizar();
        return getActual();
    }

    /**
     * Pone la pantalla indicada arriba de todas las demás, quedando como actual.
     * @param pantalla Pantalla a agregar.
     */
    public void ponerArriba(Pantalla pantalla) {
        pila.add(pantalla);
        actualizar();
    }

    /**
     * Remueve la pantalla indicada si existe.
     * @param pantalla Pantalla a remover.
     * @return Si la pantalla existía.
     */
    public boolean sacar(Pantalla pantalla) {
        if(pila.contains(pantalla))
        {
            pila.remove(pantalla);
            actualizar();
            return true;
        } else {
            return false;
        }
    }
    /**
     * Saca la pantalla actual y la devuelve.
     * @return La pantalla que fue removida, o null si no hubo.
     */
    public Pantalla sacarActual() {
        int pos = pila.size()-1;
        if(pos<0) {
            return null;
        }
        Pantalla anterior = pila.get(pos);
        pila.remove(pos);
        actualizar();
        return anterior;
    }
}
