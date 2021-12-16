package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoSargento implements IComportamientoRango{


    private int velocidad;

    public ComoSargento(Integer arrestos){

        this.velocidad = 1500;
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
        return distancia/velocidad;
    }

}
