package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

public class ComoInvestigador implements IComportamientoRango{

    private int arrestos;
    private final int arrestosASuperar = 20;
    private int tiempoPorKm;

    public ComoInvestigador(Integer arrestos){

        this.arrestos = arrestos;
        this.tiempoPorKm = 1300;

    }

    @Override
    public IComportamientoRango ascender(Integer arrestos){

        return (IComportamientoRango) new ComoSargento(arrestos);
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
