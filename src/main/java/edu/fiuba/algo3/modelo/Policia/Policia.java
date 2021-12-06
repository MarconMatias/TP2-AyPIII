package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;

import java.util.ArrayList;

public class Policia {

    private final String nombre;
    private RangoPolicia rango;

    public Policia(RangoPolicia rango, String nombre){

        this.rango = rango;
        this.nombre = nombre;
    }

    public IPista filtrarPistas(ArrayList<IPista> pistas){

        return rango.filtrarPistas(pistas);

    }

    public boolean soyElAgente(String nombreAgente) {
        return this.nombre.equals(nombreAgente);
    }

    public boolean entraAlEdificio(Edificio unEdificio, Ladron unLadron) {

        boolean pistaEncontrada = false;

        pistaEncontrada = unEdificio.generarEvento(unLadron);

        return pistaEncontrada;
    }
}
