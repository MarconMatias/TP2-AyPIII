package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.Collection;

public class ComoNovato implements IComportamientoRango {

    private Integer arrestosASuperar = 5;
    private Integer arrestos = 0;
    private int velocidad;
    private NivelPista nivelPista = new PistaFacil();

    public ComoNovato() {

        this.velocidad = 900;

    }

    @Override
    public IComportamientoRango ascender(Integer arrestos) {

        return (IComportamientoRango) new ComoDetective(arrestos);
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {
        this.arrestos = arrestos;

        if (this.arrestos >= this.arrestosASuperar)
            return this.ascender(arrestos);
        return this;
    }

    @Override
    public int estimarTiempoDeViajePara(int distancia) {
        return distancia / velocidad;
    }

    @Override
    public Collection<IPista> filtrarPistas(Collection<IPista> pistas) {
        return nivelPista.filtrarPistas(pistas);
    }
}
