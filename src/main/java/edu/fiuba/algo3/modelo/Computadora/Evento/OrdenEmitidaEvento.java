package edu.fiuba.algo3.modelo.Computadora.Evento;

import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class OrdenEmitidaEvento extends ComputadoraEvento {
    private final Ladron ladron;

    /**
     * Construye un evento emitido por Computadora al emitirse una orden válida.
     *
     * @param computadora La instancia de computadora que emite el evento.
     * @param ladron El ladrón para el que se emitió la orden.
     * @throws IllegalArgumentException si computadora es null.
     */
    public OrdenEmitidaEvento(Computadora computadora, Ladron ladron) {
        super(computadora);
        this.ladron = ladron;
    }

    public Ladron getLadron() {
        return ladron;
    }
}
