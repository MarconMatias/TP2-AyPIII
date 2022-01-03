package edu.fiuba.algo3.modelo.Lector;

import java.util.Collection;
import java.util.List;

public class LectorException extends Exception {
    private final Collection<Exception> internas;
    public LectorException(String mensaje, Collection<Exception> internas) {
        super(mensaje);
        this.internas = internas;
    }

    public LectorException(String mensaje) {
        this(mensaje, (Collection<Exception>) null);
    }

    public LectorException(String mensaje, Exception ex) {
        this(mensaje, List.of(ex));
    }

    public Collection<Exception> getInternas() {
        return internas;
    }
}
