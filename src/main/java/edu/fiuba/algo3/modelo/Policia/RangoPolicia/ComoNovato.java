package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoNovato implements IComportamientoRango{

    public ComoNovato() {

    }

    @Override
    public IComportamientoRango ascender(){

        return (IComportamientoRango) new ComoDetective();
    }
}
