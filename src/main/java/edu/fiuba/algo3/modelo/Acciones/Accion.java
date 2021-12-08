package edu.fiuba.algo3.modelo.Acciones;

public class Accion {
    IComportamientoAccion comportamiento;
    public Accion(IComportamientoAccion unComportamiento){
        comportamiento = unComportamiento;
    }
}
