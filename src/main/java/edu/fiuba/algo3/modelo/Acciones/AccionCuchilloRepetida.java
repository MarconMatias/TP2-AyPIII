package edu.fiuba.algo3.modelo.Acciones;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.IEstado;

public class AccionCuchilloRepetida implements IEstado{

    @Override
    public int demoraEdificio() {
        return 1;
    }

    @Override
    public IEstado siguiente() {
        return null;
    }
    
}
