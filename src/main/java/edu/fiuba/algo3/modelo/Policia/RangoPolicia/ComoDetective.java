package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.Collection;

public class ComoDetective implements IComportamientoRango{

    private final int arrestosASuperar = 10;
    private int arrestos;
    private int velocidad;
    private NivelPista nivelPista = new PistaFacil();

    public ComoDetective(Integer arrestos) {

        this.arrestos = arrestos;
        this.velocidad = 1100;
        this.siguienteComportamientoConArrestos(this.arrestos);
    }

    @Override
    public IComportamientoRango ascender(Integer arrestos){

        return (IComportamientoRango) new ComoInvestigador( arrestos );
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
