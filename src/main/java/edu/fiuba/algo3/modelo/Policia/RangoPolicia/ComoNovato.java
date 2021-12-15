package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoNovato implements IComportamientoRango{

    private Integer arrestosASuperar = 5;
    private Integer arrestos = 0;
    private int tiempoPorKm;

    public ComoNovato() {

        this.tiempoPorKm = 900;

    }

    @Override
    public IComportamientoRango ascender( Integer arrestos ){

        return (IComportamientoRango) new ComoDetective( arrestos );
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {

        if( this.arrestos >= this.arrestosASuperar )
            return this.ascender( arrestos );
        return null;
    }
    @Override
    public int estimarTiempoDeViajePara(int distancia) {
        return tiempoPorKm * distancia;
    }
}
