package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoDetective implements IComportamientoRango{

    private final int arrestosASuperar = 10;
    private int arrestos;

    public ComoDetective(Integer arrestos) {

        this.arrestos = arrestos;
    }

    @Override
    public IComportamientoRango ascender(Integer arrestos){

        return (IComportamientoRango) new ComoInvestigador( arrestos );
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {

        if( this.arrestos >= this.arrestosASuperar )
            return this.ascender( arrestos );
        return null;
    }
}
