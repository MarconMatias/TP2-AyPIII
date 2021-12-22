package edu.fiuba.algo3.modelo.Computadora.Evento;

import edu.fiuba.algo3.modelo.Computadora.Computadora;

public class SinOrdenEvento extends ComputadoraEvento {
    private String motivo;

    /**
     * Construye un evento emitido por Computadora cuando no se pudo generar una orden.
     *
     * @param computadora La instancia de computadora que emite el evento.
     * @param motivo Texto explicando el motivo.
     * @throws IllegalArgumentException si computadora es null.
     */
    public SinOrdenEvento(Computadora computadora, String motivo) {
        super(computadora);
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return motivo;
    }
}
