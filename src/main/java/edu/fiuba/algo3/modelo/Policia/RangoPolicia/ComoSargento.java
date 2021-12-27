package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.Collection;

public class ComoSargento implements IComportamientoRango{


    private int velocidad;
    private NivelPista nivelPista = new PistaDificil();

    public ComoSargento(){
        this.velocidad = 1500;
    }

    @Override
    public IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos) {
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
        return "Sargento";
    }

    @Override
    public String getInsignia() {
        return "\uD83D\uDE93";
    }

}
