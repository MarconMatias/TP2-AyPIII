package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
<<<<<<< HEAD
import edu.fiuba.algo3.modelo.Edificio.EdificiosEspeciales.Edificio;
import edu.fiuba.algo3.modelo.Edificio.IEdificio;
=======
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
>>>>>>> 98e67cf7bebb438f2023ea83de30f8ebb1031c8f
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

    public ArrayList<IPista> filtrarPistas(ArrayList<IPista> pistas){

        return rango.filtrarPistas(pistas);

    }

    public boolean soyElAgente(String nombreAgente) {
        return this.nombre.equals(nombreAgente);
    }

    public boolean entraAlEdificio(ITipoEdificio unEdificio, Ladron unLadron) {

        boolean pistaEncontrada = false;

        pistaEncontrada = unEdificio.mostrarPista(unLadron);

        return pistaEncontrada;
    }

    public boolean viajarACiudad(Ciudad unaCiudad) {


        return true;
    }
}
