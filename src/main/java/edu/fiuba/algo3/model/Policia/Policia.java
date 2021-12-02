package edu.fiuba.algo3.model.Policia;

import edu.fiuba.algo3.model.Edificio.Edificio;
import edu.fiuba.algo3.model.Item.Item;
import edu.fiuba.algo3.model.Ladron.Ladron;
import edu.fiuba.algo3.model.Pista.IPista;
import edu.fiuba.algo3.model.Policia.RangoPolicia.RangoPolicia;

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

    public boolean entraAlEdificio(Edificio unEdificio, Item itemRobado, Ladron unLadron) {

        boolean pistaEncontrada = false;

        pistaEncontrada = unEdificio.mostrarPistaSiExiste(unLadron);

        return pistaEncontrada;
    }
}
