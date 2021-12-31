package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Evento.PoliciaFinaliza;
import edu.fiuba.algo3.modelo.Evento.PoliciaFinalizaListener;
import edu.fiuba.algo3.modelo.Evento.PoliciaGana;
import edu.fiuba.algo3.modelo.Evento.PoliciaPierde;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.SinOrden;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.EstadoCuchillada.EstadoCuchillada;
import edu.fiuba.algo3.modelo.Policia.EstadoCuchillada.UnaChuchillada;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Policia {

    private final String nombre;
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

        if(nombre == null || cantidadDeArrestos < 0 || calendario == null)
            throw new IllegalArgumentException("Los parametros pasados por el constructor de la clase Policia son invalidos");

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

        //if(nombre == null)
        //    throw new IllegalArgumentException("El nombre del policia pasado por el constructor es invalido: es de tipo NULL");

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

        if(ordenDeArresto == null)
            throw new IllegalArgumentException("La ordenDeArresto pasado por parametro es invalida: es de tipo NULL");
        this.ordenDeArresto.set(ordenDeArresto);
    }

    /**
     * Prepara al policía para una nueva misión.
     * 
     * @param calendario Calendario de tiempo del juego durante la misión.
     */
    public void iniciarMision(Calendario calendario) {

        if(calendario == null)
            throw new IllegalArgumentException("Error. El Calendario pasado por parametro no es valido");
        this.calendario = calendario;
    }

    public int viajar(int distancia) throws CalendarioException, PoliciaException, AccionException {

        int tiempoDeViaje = rango.devolverTiempoDeViaje(distancia);
        calendario.avanzarHoras(tiempoDeViaje);
        return tiempoDeViaje;
    }

    public ArrayList<IPista> filtrarPistas(Collection<IPista> pistas) {
        return rango.filtrarPistas(pistas);
    }


    /**
     * El policía vista al edificio dado. Puede disparar acciones que avancen el calendario,
     * pero ya debe haber avanzado el calendario por la visita misma (a través de Ciudad).
     *
     * @param edificio Un edificio de la ciudad actual.
     * @return El testimonio recibido en el edificio.
     */
    public String visitar(Edificio edificio) throws AccionException, CalendarioException {
        if(edificio == null)
            throw new IllegalArgumentException("El edificio pasado por parametro es invalido: es de tipo NULL");
        return edificio.visitar(this);
    }
    public Integer getArrestos() {
        return this.arrestos;
    }

    public void avanzarHoras(int demora) throws AccionException, CalendarioException {

        try{
            calendario.avanzarHoras(demora);
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    public void realizarAccion(IAccion accion) throws AccionException, CalendarioException {

        if(accion == null)
            throw new IllegalArgumentException("La accion pasada por el metodo realizarAccion es invalida: es de tipo NULL");

        accion.setPolicia(this);
        try{
            calendario.aplicarAccion(accion);
        }
        catch (CalendarioException e){
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public void agregarArresto() {
        this.arrestos = this.arrestos + 1;
        rango.agregarArresto(this.arrestos);
    }

    public void enfrentar(Ladron ladron) {

        ordenDeArresto.get().enfrentar(this, ladron);

    }

    public void avanzarHorasCuchillada(Calendario calendario) throws AccionException, CalendarioException {

        if(calendario == null)
            throw new IllegalArgumentException("Error. El calendario pasado por parametro es invalido");
        try{
            estadoCuchilladas.avanzarHoras(calendario);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void recibirCuchillada() {
        estadoCuchilladas.siguienteEstado();
    }

    public boolean fuiAcuchillado(){
        return (estadoCuchilladas.fuiAcuchillado());
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
            final String textoError = "Sucedieron varios errores al notificar la finalización de un enfrentamiento.";
            RuntimeException error = new RuntimeException(textoError);
            /** Hacer clase de agregración, y agregar exs. **/
            for (Exception ex : exs) {
                System.err.println(ex.toString());
            }
            throw error;
        }
    }

    public void escucharAlGanar(PoliciaFinalizaListener listener) {
        oyentesAlGanar.add(listener);
    }

    public void escucharAlPerder(PoliciaFinalizaListener listener) {
        oyentesAlPerder.add(listener);
    }

    @Override
    public String toString() {
        if((null==nombre)||(nombre.trim().equals(""))) {
            return Integer.toString(hashCode());
        }
        return nombre;
    }

    public ObjectProperty<IOrden> getOrdenDeArresto() {
        return ordenDeArresto;
    }
}