package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.Collection;

public class ComoInvestigador implements IComportamientoRango{

    private int arrestos;
    private final int arrestosASuperar = 20;
    private int velocidad;
    private NivelPista nivelPista = new PistaMedia();

    public ComoInvestigador(Integer arrestos){
        this.arrestos = arrestos;
        this.velocidad = 1300;
        this.siguienteComportamientoConArrestos(this.arrestos);
    }

    @Override
    public IComportamientoRango ascender(Integer arrestos){

        return (IComportamientoRango) new ComoSargento(arrestos);
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {

        if( this.arrestos >= this.arrestosASuperar )
            return this.ascender( arrestos );
        return this;
    }


    @Override
    public int estimarTiempoDeViajePara(int distancia) {
        return distancia/velocidad;
    }


    @Override
    public Collection<IPista> filtrarPistas(Collection<IPista> pistas) {
        return nivelPista.filtrarPistas(pistas);
    }
}
