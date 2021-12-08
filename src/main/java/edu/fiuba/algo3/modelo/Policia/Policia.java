package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import edu.fiuba.algo3.modelo.Juego.*;

import java.util.ArrayList;

public class Policia {

    private final String nombre;
    private RangoPolicia rango;
    private Calendario calendario;
    private String ciudadActual;

    public Policia(RangoPolicia rango, String nombre){

        this.rango = rango;
        this.nombre = nombre;
    }

    public Policia(String nombre, int arrestos) {

        this.rango = new RangoPolicia();
        rango.actualizarArrestos(arrestos);
        this.nombre = nombre;
    }

    public ArrayList<IPista> filtrarPistas(ArrayList<IPista> pistas){

        return rango.filtrarPistas(pistas);

    }

    public boolean soyElAgente(String nombreAgente) {
        return this.nombre.equals(nombreAgente);
    }

    public String visitar(Edificio unEdificio, Ladron unLadron) {

        return unEdificio.visitar(this,calendario);
    }

    public void hacerAccion(AccionCuchilloUnica mockAccion) {
    }

    public void tomarCaso(Caso mockCaso) {
    }
}
