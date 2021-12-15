package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoSargento implements IComportamientoRango{


    private int tiempoPorKm;

    public ComoSargento(Integer arrestos){

        this.tiempoPorKm = 1500;
    }

    @Override
    public IComportamientoRango ascender(Integer arrestos) {
        return this;
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {
        return new ComoSargento( arrestos );
    }

    @Override
    public int estimarTiempoDeViajePara(int distancia) {
        return tiempoPorKm * distancia;
    }

}
