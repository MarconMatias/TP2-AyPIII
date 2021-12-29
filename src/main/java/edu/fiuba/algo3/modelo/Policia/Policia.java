package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Evento.PoliciaFinaliza;
import edu.fiuba.algo3.modelo.Evento.PoliciaFinalizaListener;
import edu.fiuba.algo3.modelo.Evento.PoliciaGana;
import edu.fiuba.algo3.modelo.Evento.PoliciaPierde;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.SinOrden;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.EstadoCuchillada.EstadoCuchillada;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Policia {

    private String nombre;
    private int arrestos;
    private RangoPolicia rango;
    private Calendario calendario;
    private ObjectProperty<IOrden> ordenDeArresto = new SimpleObjectProperty<>(new SinOrden("No se emitió nunca una orden de arresto."));
    private EstadoCuchillada estadoCuchilladas = new EstadoCuchillada();
    private List<PoliciaFinalizaListener> oyentesAlPerder = new ArrayList<>();
    private List<PoliciaFinalizaListener> oyentesAlGanar = new ArrayList<>();


    /**
     * Crea un policía con una cantidad de arrestos dada.
     * 
     * @param nombre             Nombre elegido por el policía.
     * @param cantidadDeArrestos Cantidad de arrestos que tiene el policía.
     * @param calendario         Calendario del tiempo del juego afectado por las
     *                           acciones del policía.
     */
    public Policia(String nombre, int cantidadDeArrestos, Calendario calendario) {
        this.nombre = nombre;
        this.arrestos = cantidadDeArrestos;
        this.calendario = calendario;
        this.rango = new RangoPolicia(cantidadDeArrestos);
    }

    /**
     * Crea un policía nuevo con 0 arrestos y un calendario nuevo.
     * 
     * @param nombre Nombre elegido por el policía.
     */
    public Policia(String nombre) {
        this(nombre, 0);
    }

    /**
     * Crea un policía nuevo y un calendario nuevo.
     * 
     * @param nombre             Nombre elegido por el policía.
     * @param cantidadDeArrestos Cantidad de arrestos que tiene el policía.
     */
    public Policia(String nombre, int cantidadDeArrestos) {
        this(nombre, cantidadDeArrestos, new Calendario());
    }

    public void setOrdenDeArresto(IOrden ordenDeArresto) {
        this.ordenDeArresto.set(ordenDeArresto);
    }

    /**
     * Prepara al policía para una nueva misión.
     * 
     * @param calendario Calendario de tiempo del juego durante la misión.
     */
    public void iniciarMision(Calendario calendario) {
        this.calendario = calendario;
        this.ordenDeArresto.set(new SinOrden("No se emitió nunca una orden de arresto."));
    }

    public int viajar(int distancia) {

        calendario.avanzarHoras(rango.devolverTiempoDeViaje(distancia));
        return rango.devolverTiempoDeViaje(distancia); // el return sirve para los tests

    }

    public ArrayList<IPista> filtrarPistas(Collection<IPista> pistas) {
        return rango.filtrarPistas(pistas);
    }

    /** Reemplazar por visitar(unEdificio)??? **/
    public void visitar(Edificio unEdificio, Ladron unLadron) {
        visitar(unEdificio);
    }

    /**
     * El policía vista al edificio dado. Puede disparar acciones que avancen el calendario,
     * pero ya debe haber avanzado el calendario por la visita misma (a través de Ciudad).
     *
     * @param edificio Un edificio de la ciudad actual.
     * @return El testimonio recibido en el edificio.
     */
    public String visitar(Edificio edificio) {
        return edificio.visitar(this);
    }

    public void hacerAccion(AccionCuchilloUnica mockAccion) {
    }

    public Integer getArrestos() {
        return this.arrestos;
    }

    public void avanzarHoras(int demora) {
        calendario.avanzarHoras(demora);
    }

    public void realizarAccion(IAccion accion) {
        accion.setPolicia(this);
        calendario.aplicarAccion(accion);
    }

    public void agregarArresto() {
        this.arrestos = this.arrestos + 1;
        rango.agregarArresto(this.arrestos);
    }

    public void enfrentar(Ladron ladron) {
        ordenDeArresto.get().enfrentar(this, ladron);
    }

    public void avanzarHorasCuchillada(Calendario calendario) {
        estadoCuchilladas.avanzarHoras(calendario);
    }

    public void recibirCuchillada() {
        estadoCuchilladas.siguienteEstado();
    }

    public void ganar(String explicacion) {
        PoliciaGana evento = new PoliciaGana(this, explicacion);
        notificarListeners(oyentesAlGanar, evento);
    }

    public void perder(String explicacion) {
        PoliciaPierde evento = new PoliciaPierde(this, explicacion);
        notificarListeners(oyentesAlPerder, evento);
    }

    private void notificarListeners(List<PoliciaFinalizaListener> listeners, PoliciaFinaliza evento) {
        List<Exception> exs = new ArrayList<>();
        for (PoliciaFinalizaListener listener : listeners) {
            try {
                listener.handle(evento);
            } catch (RuntimeException ex) {
                exs.add(ex);
            }
        }
        if (exs.size() > 0) {
            System.err.println("Sucedieron "+exs.size()+" errores al notificar la finalización de un enfrentamiento.");
            for(int i=0; i< exs.size(); i++) {
                System.err.println("Error "+i+":");
                exs.get(i).printStackTrace();
            }
            System.err.println("────────────────────────────────");
        }
    }

    public void escucharAlGanar(PoliciaFinalizaListener listener) {
        oyentesAlGanar.add(listener);
    }

    public void escucharAlPerder(PoliciaFinalizaListener listener) {
        oyentesAlPerder.add(listener);
    }

    private String getNombre() {
        if((null==nombre)||(nombre.trim().equals(""))) {
            return nombre = "#"+Integer.toString(hashCode());
        } else {
            return nombre;
        }
    }
    @Override
    public String toString() {
        String valor = getNombre();
        return rango.getInsignia()+" "+valor;
    }

    public ObjectProperty<IOrden> getOrdenDeArresto() {
        return ordenDeArresto;
    }

    public String getRangoYNombre() {
        return rango.getNombreRango() + " " + getNombre();
    }
}