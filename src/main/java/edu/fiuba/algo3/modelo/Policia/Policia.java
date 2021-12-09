package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Acciones.Accion;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import edu.fiuba.algo3.modelo.Juego.*;

import java.util.ArrayList;
import java.util.Collection;

public class Policia {

    private final String nombre;
    private final int arrestos;
    private RangoPolicia rango;
    private Calendario calendario;
    private String ciudadActual;

    /**
     * Crea un policía con una cantidad de arrestos dada.
     * @param nombre Nombre elegido por el policía.
     * @param cantidadDeArrestos Cantidad de arrestos que tiene el policía.
     * @param calendario Calendario del tiempo del juego afectado por las acciones del policía.
     */
    public Policia(String nombre, int cantidadDeArrestos, Calendario calendario) {
        this.nombre = nombre;
        this.arrestos = cantidadDeArrestos;
        this.calendario = calendario;
        this.rango = new RangoPolicia(cantidadDeArrestos);
    }

<<<<<<< HEAD
    public Policia(String nombre, int arrestos) {

        this.rango = new RangoPolicia();
        rango.actualizarArrestos(arrestos);
        this.nombre = nombre;
    }

    public ArrayList<IPista> filtrarPistas(ArrayList<IPista> pistas){
=======
    /**
     * Crea un policía nuevo con 0 arrestos y un calendario nuevo.
     * @param nombre Nombre elegido por el policía.
     */
    public Policia(String nombre) {
        this(nombre,0);
    }
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e

    /**
     * Crea un policía nuevo y un calendario nuevo.
     * @param nombre Nombre elegido por el policía.
     * @param cantidadDeArrestos Cantidad de arrestos que tiene el policía.
     */
    public Policia(String nombre, int cantidadDeArrestos) {
        this(nombre,0, new Calendario());
    }

    /**
     * Prepara al policía para una nueva misión.
     * @param calendario Calendario de tiempo del juego durante la misión.
     */
    public void iniciarMision(Calendario calendario) {
        this.calendario = calendario;
    }


    public void viajar(int distancia)
    {

    }
    public ArrayList<IPista> filtrarPistas(Collection<IPista> pistas){
        return rango.filtrarPistas(pistas);
    }

    public boolean soyElAgente(String nombreAgente) {
        return this.nombre.equals(nombreAgente);
    }

<<<<<<< HEAD
    public String visitar(Edificio unEdificio, Ladron unLadron) {
=======
    public void visitar(Edificio unEdificio, Ladron unLadron) {

        unEdificio.visitar(this);
        return;
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e

        return unEdificio.visitar(this,calendario);
    }

    public void hacerAccion(AccionCuchilloUnica mockAccion) {
    }

    public void tomarCaso(Caso mockCaso) {
    }

    public Object getArrestos() {
        return this.arrestos;
    }

    public void avanzarHoras(int demora) {
        calendario.avanzarHoras(demora);
    }

    public void realizarAccion(IAccion herida) {
        calendario.aplicarAccion(herida);
    }
}