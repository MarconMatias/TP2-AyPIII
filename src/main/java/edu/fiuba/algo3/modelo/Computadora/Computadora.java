package edu.fiuba.algo3.modelo.Computadora;

import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Ladron.SinSospechoso;
import edu.fiuba.algo3.modelo.OrdenDeArresto.OrdenValida;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computadora {

    private final List<Ladron> sospechososRegistrados;
    private Map<String,String> detalles = new HashMap<String,String>();
    private ISospechoso sospechoso = new SinSospechoso();

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

    public void generarOrdenDeArresto() {
        List<Ladron> sospechosos = buscarSospechosos();
        if(sospechosos.size()>1) {
            //throw new RuntimeException("Hay demasiados sospechosos, ingrese más detalles.");
            return;
        } else if(sospechosos.size()<1) {
            //throw new RuntimeException("No hay ningún sospechoso con los detalles ingresados.");
            return;
        }
        this.sospechoso = sospechosos.get(0);
        this.ordenDeArresto = new Orden(this.sospechoso);
    }
}
