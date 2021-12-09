package edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas;

public class Visito1Edificio implements IEstado{
    @Override
    public int demoraEdificio() {
        return 2;
    }

    @Override
    public IEstado siguiente() {
        return new VisitoMuchosEdificios();
    }
}
