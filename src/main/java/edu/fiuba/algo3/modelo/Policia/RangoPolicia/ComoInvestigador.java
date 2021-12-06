package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoInvestigador implements IComportamientoRango{

    public ComoInvestigador(){

    }

    @Override
    public IComportamientoRango ascender(){

        return (IComportamientoRango) new ComoSargento();
    }
}
