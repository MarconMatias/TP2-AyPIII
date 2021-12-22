package edu.fiuba.algo3.modelo.Computadora.Evento;

import edu.fiuba.algo3.modelo.Computadora.Computadora;

public class DetalleModificadoEvento extends ComputadoraEvento {
    private final String tipo;
    private final String valor;

    /**
     * Construye un evento emitido por Computadora para indicar que un detalle se modificó.
     * @param computadora La instancia de computadora que emite el evento.
     * @param tipo El texto del tipo de detalle.
     * @param valor El texto del valor de detalle (null en caso de desconocido).
     */
    public DetalleModificadoEvento(Computadora computadora, String tipo, String valor) {
        super(computadora);
        this.tipo = tipo;
        this.valor = valor;
    }

    public boolean esTipo(String tipoBuscado) {
        if( (null == tipo) || (null == tipoBuscado) ) {
            return tipo == tipoBuscado;
        } else {
            return tipo.trim().equals(tipoBuscado.trim());
        }
    }
}
