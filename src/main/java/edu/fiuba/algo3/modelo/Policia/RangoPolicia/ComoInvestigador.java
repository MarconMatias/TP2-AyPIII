package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.Collection;

public class ComoInvestigador implements IComportamientoRango{

    private final int arrestosASuperar = 20;
    private int velocidad;
    private NivelPista nivelPista = new PistaMedia();

    public ComoInvestigador(){
        this.velocidad = 1300;
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {
        if(arrestos >= arrestosASuperar) {
            IComportamientoRango siguiente = new ComoSargento();
            return siguiente.siguienteComportamientoConArrestos(arrestos);
        }
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

    @Override
    public String getNombreRango() {
        return "Investigador";
    }

    @Override
    public String getInsignia() {
        return "\uD83D\uDEA8";
    }
}
