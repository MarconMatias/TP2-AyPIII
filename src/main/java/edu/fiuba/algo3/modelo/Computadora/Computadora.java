package edu.fiuba.algo3.modelo.Computadora;

import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Ladron.SinSospechoso;
import edu.fiuba.algo3.modelo.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.Orden;
import edu.fiuba.algo3.modelo.OrdenDeArresto.SinOrden;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computadora {

    private final List<Ladron> sospechososRegistrados;
    private Map<String,String> detalles = new HashMap<String,String>();

    public Computadora(List<Ladron> ladrones) {
        sospechososRegistrados = ladrones;
    }

    public void agregarDetalle(String tipo, String valor){

        detalles.put(tipo,valor);

    }

    public ArrayList<Ladron> buscarSospechosos() {

        ArrayList<Ladron> sospechososFiltrados = new ArrayList<Ladron>();
        for(Ladron l : sospechososRegistrados ){
            l.agregarSiCoincideDetalle(detalles,sospechososFiltrados);
        }
        return sospechososFiltrados;
    }

    public IOrden generarOrdenDeArresto() {
        List<Ladron> sospechosos = buscarSospechosos();
        if(sospechosos.size()>1) {
            //throw new RuntimeException("Hay demasiados sospechosos, ingrese más detalles.");
            return new SinOrden();
        } else if(sospechosos.size()<1) {
            //throw new RuntimeException("No hay ningún sospechoso con los detalles ingresados.");
            return new SinOrden();
        }
        Ladron sospechoso = sospechosos.get(0);
        return new Orden(sospechoso);

    }
}
