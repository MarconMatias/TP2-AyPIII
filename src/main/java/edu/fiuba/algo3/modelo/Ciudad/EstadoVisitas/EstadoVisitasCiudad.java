package edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas;

public class EstadoVisitasCiudad {
    IEstado estado = new SinVisitas();

    public void siguiente() {
        estado = estado.siguiente();
    }

    public int demoraEdificio()
    {
        return estado.demoraEdificio();
    }
}
