package edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion;

public class AccionException extends Exception {

    private final String mensaje;

    public AccionException(String mensaje) {
        this.mensaje = mensaje;
    }
}
