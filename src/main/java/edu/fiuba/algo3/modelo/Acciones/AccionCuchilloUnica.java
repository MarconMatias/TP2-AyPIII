package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.IEstado;

public class AccionCuchilloUnica implements IEstado{

    @Override
    public int demoraEdificio() {
        return 2;
    }

    @Override
    public IEstado siguiente() {
        return new AccionCuchilloRepetida();
    }
    
}
