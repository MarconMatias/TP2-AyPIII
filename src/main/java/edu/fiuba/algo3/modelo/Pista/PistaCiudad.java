package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.ArrayList;
import java.util.Collection;

public class PistaCiudad implements IPista {

    private final String tipo;
    private final String pista;
    private final NivelPista nivel;

    public PistaCiudad(String tipo, String pista, NivelPista nivel) {
        this.tipo = tipo;
        this.pista = pista;
        this.nivel = nivel;
    }

    @Override
    public void agregarAListaSiEsNivel(ArrayList<IPista> pistas, NivelPista nivel) {
        if(this.nivel.esEquivalente(nivel))
        {
            pistas.add(this);
        }

    }

    public boolean esDeUnTipoDe(Collection<String> tipos) {
        return tipos.stream().anyMatch(buscado -> this.tipo == buscado);
    }

    @Override
    public String toString() {
        return "Un dato sobre " + tipo + ":" + pista;
    }

}
