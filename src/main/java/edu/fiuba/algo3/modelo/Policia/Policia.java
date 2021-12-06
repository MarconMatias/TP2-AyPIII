package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.EdificiosEspeciales.Edificio;
import edu.fiuba.algo3.modelo.Edificio.IEdificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Policia {

    private final String nombre;
    private RangoPolicia rango;

    public Policia(RangoPolicia rango, String nombre){

        this.rango = rango;
        this.nombre = nombre;
    }

    public ArrayList<IPista> filtrarPistas(Collection<PistaCiudad> pistas){

        return rango.filtrarPistas(pistas);

    }

    public boolean soyElAgente(String nombreAgente) {
        return this.nombre.equals(nombreAgente);
    }

    public boolean entraAlEdificio(IEdificio unEdificio, Ladron unLadron) {

        boolean pistaEncontrada = false;

        pistaEncontrada = unEdificio.generarEvento(unLadron);

        return pistaEncontrada;
    }

    public boolean viajarACiudad(Ciudad unaCiudad) {


        return true;
    }
}
