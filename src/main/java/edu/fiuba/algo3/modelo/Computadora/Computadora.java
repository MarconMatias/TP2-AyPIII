package edu.fiuba.algo3.modelo.Computadora;

import edu.fiuba.algo3.modelo.Computadora.Evento.*;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Orden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.SinOrden;

import java.util.*;

public class Computadora {

    private final List<Ladron> sospechososRegistrados;
    private final Map<String,Set<String>> tiposDeDetalles = new HashMap<>();

    private final Map<String,String> detalles = new HashMap<String,String>();
    private List<ComputadoraListener> oyentesTodos = new ArrayList<>();

    /**
     * Crea una computadora de interpol.
     * @param ladrones El listado de ladrones aceptados, con sus detalles.
     */
    public Computadora(List<Ladron> ladrones) {
        sospechososRegistrados = ladrones;
        for(Ladron ladron : ladrones) {
            ladron.agregarDetallesAMap(tiposDeDetalles);
        }
    }

    /**
     * Agrega un detalle a la orden a confeccionar.
     * @param tipo Texto del tipo de detalle. Debe coincidir con los suministrados en getTiposDeDetalles().
     * @param valor Texto del valor de detalle. Debe ser uno de getValoresDeDetalleTipo(),
     *              o null (para indicar detalle desconocido).
     */
    public void agregarDetalle(String tipo, String valor) {
        if(null == valor) {
            if(detalles.containsKey(tipo)) {
                detalles.remove(tipo);
            }
        } else {
            detalles.put(tipo,valor);
        }
        notificarOyentes(new DetalleModificadoEvento(this,tipo,valor));
    }

    /**
     * Busca los sospechosos que coinciden con los detalles aportados.
     * @return Una lista de ladrones.
     */
    public ArrayList<Ladron> buscarSospechosos() {
        ArrayList<Ladron> sospechososFiltrados = new ArrayList<Ladron>();
        for(Ladron l : sospechososRegistrados ){
            l.agregarSiCoincideDetalle(detalles,sospechososFiltrados);
        }
        return sospechososFiltrados;
    }

    /**
     * Agrega al listener para escuchar todos los eventos emitidos por esta computadora.
     * @param listener Acepta cualquier evento ComputadoraEvento en el método handle.
     */
    public void oirTodo(ComputadoraListener listener) {
        oyentesTodos.add(listener);
    }

    /**
     * Genera una orden de arresto con los detalles suministrados. Emite un evento de tipo
     * OrdenEmitidaEvento si pudo generarla, o SinOrdenEvento en caso contrario.
     * @return Un objeto Orden o un objeto SinOrden, según si pudo o no generarla.
     */
    public IOrden generarOrdenDeArresto() {
        final String textoDemasiados = "Hay demasiados sospechosos, ingrese más detalles.";
        final String textoNinguno = "No hay ningún sospechoso con los detalles ingresados.";

        List<Ladron> sospechosos = buscarSospechosos();
        if(sospechosos.size()>1) {
            notificarOyentes(new SinOrdenEvento(this,textoDemasiados));
            return new SinOrden();
        } else if(sospechosos.size()<1) {
            notificarOyentes(new SinOrdenEvento(this,textoNinguno));
            return new SinOrden();
        }
        Ladron sospechoso = sospechosos.get(0);
        notificarOyentes(new OrdenEmitidaEvento(this, sospechoso));
        return new Orden(sospechoso);
    }

    /**
     * Notifica a los oyentes de una lista sobre un evento dado.
     * @param oyentes Lista de oyentes a ser notificados.
     * @param evento Evento a notificar.
     */
    private void notificarOyentes(List<ComputadoraListener> oyentes, ComputadoraEvento evento) {
        for(ComputadoraListener oyente : oyentes) {
            try {
                oyente.handle(evento);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Notifica a todos los oyentes correspondientes sobre un tipo de evento.
     * @param evento
     */
    private void notificarOyentes(ComputadoraEvento evento) {
        notificarOyentes(oyentesTodos, evento);
    }

    /**
     * Devuelve el valor actual de un tipo de detalle dado.
     * @param tipo Texto con el tipo de detalle, debe coincidir con uno de getTiposDeDetalles().
     * @return El valor actual del detalle dado, coincidente con getValoresDeDetalleTipo();
     *          o null si el valor del detalle es desconocido.
     */
    public String obtenerDetalle(String tipo) {
        return detalles.get(tipo);
    }

    /**
     * @return Un conjunto de textos de tipo detalles admitidos. Ej: pelo, sexo…
     */
    public Set<String> getTiposDeDetalles() {
        return tiposDeDetalles.keySet();
    }

    /**
     * Devuelve los valores admitidos para un tipo de detalle.
     * @param tipo Texto con el tipo de detalle, debe coincidir con uno de getTiposDeDetalles().
     * @return Un conjunto de valores admitidos (además de null). Ej: masculino, femenino.
     */
    public Set<String> getValoresDeDetalleTipo(String tipo) {
        return tiposDeDetalles.get(tipo);
    }
}
