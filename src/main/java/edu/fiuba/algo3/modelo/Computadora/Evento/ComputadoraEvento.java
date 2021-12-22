package edu.fiuba.algo3.modelo.Computadora.Evento;

import edu.fiuba.algo3.modelo.Computadora.Computadora;

import java.util.EventObject;

public class ComputadoraEvento extends EventObject {
    /**
     * Construye un evento emitido por Computadora.
     *
     * @param computadora La instancia de computadora que emite el evento.
     * @throws IllegalArgumentException si computadora es null.
     */
    public ComputadoraEvento(Computadora computadora) {
        super(computadora);
    }
}
