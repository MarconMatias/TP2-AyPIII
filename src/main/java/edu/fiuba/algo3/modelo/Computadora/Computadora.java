package edu.fiuba.algo3.modelo.Computadora;

import edu.fiuba.algo3.modelo.Ladron.Ladron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Computadora {

    private final ArrayList<Ladron> sospechososRegistrados;
    private Map<String,String> detalles = new HashMap<String,String>();

    public Computadora(ArrayList<Ladron> ladrones) {
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
}
