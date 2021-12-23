package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;

import java.util.ArrayList;

public class PistaLadron implements IPista {

    protected final static String noHayDetalles = "No puedo aportar ningún detalle sobre esa persona.";
    private final NivelPista nivel;
    protected final String tipo;
    protected final String valor;

    public PistaLadron(String tipo, String valor, NivelPista nivel) {
        this.tipo = tipo;
        this.valor = valor;
        this.nivel = nivel;
    }

    public static String textoNoHay() {
        return noHayDetalles;
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
        if( (null == tipo) || ("".equals(tipo.trim()))
                || (null == valor)  || ("".equals(valor.trim())) ) {
            return noHayDetalles;
        }
        return "Su " + tipo + " es " + valor + ".";
    }
}
