package edu.fiuba.algo3.modelo.Pista.NivelPista;

public class PistaFacil extends NivelPista {

    @Override
    public boolean esEquivalente(NivelPista nivel) {
        return (nivel instanceof PistaFacil) || (nivel instanceof PistaTodoNivel);
    }
}
