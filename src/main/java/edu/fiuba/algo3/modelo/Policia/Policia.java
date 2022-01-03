package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Calendario.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Calendario.Evento.PoliciaFinaliza;
import edu.fiuba.algo3.modelo.Calendario.Evento.PoliciaFinalizaListener;
import edu.fiuba.algo3.modelo.Calendario.Evento.PoliciaGana;
import edu.fiuba.algo3.modelo.Calendario.Evento.PoliciaPierde;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.SinOrden;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.EstadoCuchillada.EstadoCuchillada;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
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

        if(nombre == null || cantidadDeArrestos < 0 || calendario == null)
            throw new IllegalArgumentException("Error. Alguno de los parametros pasados al constructor de policia no es valido.");
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

    public void setOrdenDeArresto(IOrden ordenDeArresto) throws PoliciaException {

        if(ordenDeArresto == null)
            throw new PoliciaException("Error. No se pudo setear la orden de arresto porque no es una orden valida.");
        this.ordenDeArresto.set(ordenDeArresto);
    }

    /**
     * Prepara al policía para una nueva misión.
     * 
     * @param calendario Calendario de tiempo del juego durante la misión.
     */
    public void iniciarMision(Calendario calendario) {
        if(calendario == null)
            throw new IllegalArgumentException("Error. El calendario pasado por parametro no es valido.");
        this.calendario = calendario;
        this.ordenDeArresto.set(new SinOrden("No se emitió nunca una orden de arresto."));
    }

    public int viajar(int distancia) throws PoliciaException {
        try {
            int tiempoDeViaje = rango.devolverTiempoDeViaje(distancia);
            calendario.avanzarHoras(tiempoDeViaje);
            return tiempoDeViaje;
        } catch (CalendarioException ex) {
            throw new PoliciaException("El policía no pudo realizar el viaje.\n"+ex);
        }
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
    public String visitar(Edificio edificio) throws PoliciaException {
        if(edificio == null)
            throw new IllegalArgumentException("El edificio a visitar por el policía no es válido.");
        try {
            return edificio.visitar(this);
        } catch (CalendarioException ex) {
            throw new PoliciaException("El policía no pudo visitar el edificio.\n"+ex);
        }
    }

    public Integer getArrestos() {
        return this.arrestos;
    }

    public void avanzarHoras(int demora) throws PoliciaException {
        try {
            calendario.avanzarHoras(demora);
        } catch (CalendarioException ex) {
            throw new PoliciaException("El policía no pudo acanzar "+demora+" horas.\n"+ex);
        }
    }

    public void realizarAccion(IAccion accion) throws PoliciaException {
        try {
            accion.setPolicia(this);
            calendario.aplicarAccion(accion);
        } catch (CalendarioException ex) {
            throw new PoliciaException("El policía no pudo realizar la acción.\n"+ex);
        }
    }

    public void agregarArresto() {
        this.arrestos = this.arrestos + 1;
        rango.agregarArresto(this.arrestos);
    }

    public void enfrentar(Ladron ladron) {
        ordenDeArresto.get().enfrentar(this, ladron);
    }

    public void avanzarHorasCuchillada(Calendario calendario) throws PoliciaException {
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
        // Hace una copia porque a veces modificado durante la llamada a los observadores:
        PoliciaFinalizaListener[] observadoresAntes = listeners.toArray(new PoliciaFinalizaListener[0]);
        List<Exception> exs = new ArrayList<>();
        for (PoliciaFinalizaListener listener : observadoresAntes) {
            try {
                if(listeners.contains(listener)) {
                    listener.handle(evento);
                }
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

    public void desescucharAlGanar(PoliciaFinalizaListener oyenteGanar) {
        oyentesAlGanar.remove(oyenteGanar);
    }

    public void escucharAlPerder(PoliciaFinalizaListener listener) {
        oyentesAlPerder.add(listener);
    }

    public void desescucharAlPerder(PoliciaFinalizaListener oyentePerder) {
        oyentesAlPerder.remove(oyentePerder);
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