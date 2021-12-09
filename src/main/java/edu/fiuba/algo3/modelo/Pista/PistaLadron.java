package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public class PistaLadron implements IPista {

    private final NivelPista nivel;
    private final String tipo;
    private final String valor;

    public PistaLadron(String tipo, String valor, NivelPista nivel) {
        this.tipo = tipo;
        this.valor = valor;
        this.nivel = nivel;
    }

    @Override
    public void agregarAListaSiEsNivel(ArrayList<IPista> pistas, NivelPista nivel) {
        if(this.nivel.esEquivalente(nivel))
        {
            pistas.add(this);
        }
    }

    @Override
    public String toString()
    {
        return "Su " + tipo + " es " + valor + ".";
    }
}
