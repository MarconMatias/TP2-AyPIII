package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoNovato implements IComportamientoRango{

    private Integer arrestosASuperar = 5;
    private Integer arrestos = 0;

    public ComoNovato() {

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
}
