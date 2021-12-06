package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoDetective implements IComportamientoRango{

    public ComoDetective(){

    }
    @Override
    public IComportamientoRango ascender(){

        return (IComportamientoRango) new ComoInvestigador();
    }
}
