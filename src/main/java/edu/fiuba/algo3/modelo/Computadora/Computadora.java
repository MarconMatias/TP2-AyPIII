package edu.fiuba.algo3.modelo.Computadora;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.Orden;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.SinOrden;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.*;

public class Computadora {

    private final List<Ladron> sospechososRegistrados;
    private ObservableList<Ladron> sospechososRegistradosObservables;
    private final Map<String, Set<String>> tiposDeDetalles = new HashMap<>();

    private final Map<String, String> detalles = new HashMap<String, String>();
    private final ObservableMap<String, String> detallesObservable = FXCollections.observableMap(detalles);
    private final List<Ladron> sospechososFiltrados = new ArrayList<>();
    private ObservableList<Ladron> sospechososObservables = FXCollections.observableList(sospechososFiltrados);

    /**
     * Crea una computadora de interpol.
     * 
     * @param ladrones El listado de ladrones aceptados, con sus detalles.
     */
    public Computadora(List<Ladron> ladrones) {
        sospechososRegistrados = ladrones;
        sospechososFiltrados.addAll(sospechososRegistrados);
        for (Ladron ladron : ladrones) {
            ladron.agregarDetallesAMap(tiposDeDetalles);
        }
        sospechososRegistradosObservables = FXCollections.observableList(sospechososRegistrados);
    }

    /**
     * Agrega un detalle a la orden a confeccionar (modifica observable
     * getDetalles()).
     * 
     * @param tipo  Texto del tipo de detalle. Debe coincidir con los suministrados
     *              en getTiposDeDetalles().
     * @param valor Texto del valor de detalle. Debe ser uno de
     *              getValoresDeDetalleTipo(),
     *              o null (para indicar detalle desconocido).
     */
    public void agregarDetalle(String tipo, String valor) {
        if (null == valor) {
            if (detallesObservable.containsKey(tipo)) {
                detallesObservable.remove(tipo);
            }
        } else {
            detallesObservable.put(tipo, valor);
        }
        recalcularSospechosos();
    }

    private void recalcularSospechosos() {
        Collection<Ladron> calculados = buscarSospechosos();
        // Remover elementos anteriores que no estén en la lista nueva:
        sospechososObservables.removeIf(anterior -> !calculados.contains(anterior));
        // Agregar elementos nuevos que no estén en la lista vieja:
        for (Ladron nuevo : calculados) {
            if (!sospechososObservables.contains(nuevo)) {
                sospechososObservables.add(nuevo);
            }
        }
    }

    /**
     * Busca los sospechosos que coinciden con los detalles aportados.
     * 
     * @return Una lista de ladrones.
     */
    public ArrayList<Ladron> buscarSospechosos() {
        ArrayList<Ladron> sospechososFiltrados = new ArrayList<Ladron>();
        for (Ladron l : sospechososRegistrados) {
            l.agregarSiCoincideDetalle(detalles, sospechososFiltrados);
        }
        return sospechososFiltrados;
    }

    /**
     * Genera una orden de arresto con los detalles suministrados.
     * 
     * @return Un objeto Orden o un objeto SinOrden, según si pudo o no generarla.
     */
    public IOrden generarOrdenDeArresto() {
        final String textoDemasiados = "Hay demasiados sospechosos, ingrese más detalles.";
        final String textoNinguno = "No hay ningún sospechoso con los detalles ingresados.";

        List<Ladron> sospechosos = buscarSospechosos();
        if (sospechosos.size() > 1) {
            return new SinOrden(textoDemasiados);
        } else if (sospechosos.size() < 1) {
            return new SinOrden(textoNinguno);
        }
        Ladron sospechoso = sospechosos.get(0);
        return new Orden(sospechoso);
    }

    /**
     * Devuelve el valor actual de un tipo de detalle dado.
     * 
     * @param tipo Texto con el tipo de detalle, debe coincidir con uno de
     *             getTiposDeDetalles().
     * @return El valor actual del detalle dado, coincidente con
     *         getValoresDeDetalleTipo();
     *         o null si el valor del detalle es desconocido.
     */
    public String obtenerDetalle(String tipo) {
        return detallesObservable.get(tipo);
    }

    public ObservableMap<String, String> getDetalles() {
        return detallesObservable;
    }

    /**
     * @return Un conjunto de textos de tipo detalles admitidos. Ej: pelo, sexo…
     */
    public Set<String> getTiposDeDetalles() {
        return tiposDeDetalles.keySet();
    }

    /**
     * Devuelve los valores admitidos para un tipo de detalle.
     * 
     * @param tipo Texto con el tipo de detalle, debe coincidir con uno de
     *             getTiposDeDetalles().
     * @return Un conjunto de valores admitidos (además de null). Ej: masculino,
     *         femenino.
     */
    public Set<String> getValoresDeDetalleTipo(String tipo) {
        return tiposDeDetalles.get(tipo);
    }

    public ObservableList<Ladron> getSospechososObservables() {
        return sospechososObservables;
    }

    public ObservableList<Ladron> getSospechososRegistradosObservables() {
        return sospechososRegistradosObservables;
    }

}
