package edu.fiuba.algo3.modelo.Pista.NivelPista;

public class PistaMedia extends NivelPista {

    @Override
    public boolean esEquivalente(NivelPista nivel) {
        return nivel instanceof PistaMedia;
    }
}
