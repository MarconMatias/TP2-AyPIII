package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.Collection;

public class ComoSargento implements IComportamientoRango{


    private int velocidad;
    private NivelPista nivelPista = new PistaDificil();

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


    @Override
    public Collection<IPista> filtrarPistas(Collection<IPista> pistas) {
        return nivelPista.filtrarPistas(pistas);
    }

}
