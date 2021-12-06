package edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas;

public class VisitoMuchosEdificios implements IEstado{
    @Override
    public int demoraEdificio() {
        return 3;
    }

    @Override
    public IEstado siguiente() {
        return this;
    }
}
