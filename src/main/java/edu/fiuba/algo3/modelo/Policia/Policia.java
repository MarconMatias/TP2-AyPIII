package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.OrdenDeArresto.*;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import edu.fiuba.algo3.modelo.Policia.EstadoCuchillada.*;

import java.util.ArrayList;
import java.util.Collection;

public class Policia {

    private final String nombre;
    private int arrestos;
    private RangoPolicia rango;
    private Calendario calendario;
    private String ciudadActual;
    private IOrden ordenDeArresto = new SinOrden();
    private EstadoCuchillada estadoCuchilladas = new EstadoCuchillada();

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

    /**
     * Crea un policía nuevo con 0 arrestos y un calendario nuevo.
     * @param nombre Nombre elegido por el policía.
     */
    public Policia(String nombre) {
        this(nombre,0);
    }

    /**
     * Crea un policía nuevo y un calendario nuevo.
     * @param nombre Nombre elegido por el policía.
     * @param cantidadDeArrestos Cantidad de arrestos que tiene el policía.
     */
    public Policia(String nombre, int cantidadDeArrestos) {
        this(nombre,0, new Calendario());
    }

    public void setOrdenDeArresto(IOrden ordenDeArresto) {
        this.ordenDeArresto = ordenDeArresto;
    }

    /**
     * Prepara al policía para una nueva misión.
     * @param calendario Calendario de tiempo del juego durante la misión.
     */
    public void iniciarMision(Calendario calendario) {
        this.calendario = calendario;
    }


    public int viajar(int distancia)
    {
        calendario.avanzarHoras(rango.devolverTiempoDeViaje(distancia));
        return rango.devolverTiempoDeViaje(distancia); //el return sirve para los tests

    }
    public ArrayList<IPista> filtrarPistas(Collection<IPista> pistas){
        return rango.filtrarPistas(pistas);
    }

    public boolean soyElAgente(String nombreAgente) {
        return this.nombre.equals(nombreAgente);
    }

    /** Reemplazar por visitar(unEdificio)??? **/
    public void visitar(Edificio unEdificio, Ladron unLadron) {
        visitar(unEdificio);
    }

    public void visitar(Edificio unEdificio) {
        unEdificio.visitar(this);
        return;
    }

    public void hacerAccion(AccionCuchilloUnica mockAccion) {
    }

    public Object getArrestos() {
        return this.arrestos;
    }

    public void avanzarHoras(int demora) {
        calendario.avanzarHoras(demora);
    }

    public void realizarAccion(IAccion accion) {
        accion.setPolicia(this);
        calendario.aplicarAccion(accion);
    }

    public void agregarArresto(){
        this.arrestos = this.arrestos + 1;
        rango.agregarArresto(this.arrestos);
    }

    public void enfrentar(Ladron ladron) {
        ordenDeArresto.enfrentar(this,ladron);
    }

    public void avanzarHorasCuchillada(Calendario calendario) {
        estadoCuchilladas.avanzarHoras(calendario);
        calendario.avanzarHoras(2);
    }

    public void recibirCuchillada() {
        estadoCuchilladas.siguienteEstado();
    }
}