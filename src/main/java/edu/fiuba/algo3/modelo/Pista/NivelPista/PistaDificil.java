package edu.fiuba.algo3.modelo.Pista.NivelPista;

public class PistaDificil extends NivelPista {

    public PistaDificil() {
        super();

    }

    @Override
    public boolean esEquivalente(NivelPista nivel) {
        return nivel instanceof PistaDificil;
    }
}
