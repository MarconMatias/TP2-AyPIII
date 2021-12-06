package edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas;

public class SinVisitas implements IEstado{
    @Override
    public int demoraEdificio() {
        return 1;
    }

    @Override
    public IEstado siguiente() {
        return new Visito1Edificio();
    }
}
