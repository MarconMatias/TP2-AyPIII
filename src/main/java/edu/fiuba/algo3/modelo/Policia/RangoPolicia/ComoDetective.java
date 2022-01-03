package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.Collection;

public class ComoDetective implements IComportamientoRango{

    private final int arrestosASuperar = 10;
    private int velocidad;
    private NivelPista nivelPista = new PistaFacil();

    public ComoDetective() {
        this.velocidad = 1100;
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {
        if(arrestos >= arrestosASuperar) {
            IComportamientoRango siguiente = new ComoInvestigador();
            return siguiente.siguienteComportamientoConArrestos(arrestos);
        }
        return this;
    }


    @Override
    public int estimarTiempoDeViajePara(int distancia) {
        if(distancia < 0)
            throw new IllegalArgumentException("Error. La distancia pasada por parametro es invalida");
        return distancia / velocidad;
    }

    @Override
    public Collection<IPista> filtrarPistas(Collection<IPista> pistas) {
        return nivelPista.filtrarPistas(pistas);
    }

    @Override
    public String getNombreRango() {
        return "Detective";
    }

    @Override
    public String getInsignia() {
        return "\uD83D\uDD75";
    }
}
