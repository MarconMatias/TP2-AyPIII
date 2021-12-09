package edu.fiuba.algo3.modelo.Item;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Juego.Mapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {

    private final String nombreDelItem;
    private final String nombreCiudadDelRobo;

    public Item(String nombreDelItem, String nombreCiudadDelRobo){

        this.nombreDelItem = nombreDelItem;
        this.nombreCiudadDelRobo = nombreCiudadDelRobo;
    }

    public boolean estaElItem(String nombreItem) {
        return this.nombreDelItem.equals(nombreItem);
    }

    public String getNombre() {
        return nombreDelItem;
    }

    public String getNombreCiudadDelRobo() {
        return nombreCiudadDelRobo;
    }

    public Ciudad getCiudadInicial(Mapa unMapa) {
        return unMapa.getCiudadPorNombre(this.nombreCiudadDelRobo);
    }

    public List<String> getRuta(Mapa unMapa, Random random) {
        /** \todo Usar nivelItem. **/
        List<String> ruta = new ArrayList<>(List.of(nombreCiudadDelRobo));
        while(ruta.size() < 4) {
            unMapa.agregarSiguiente(ruta,random);
        }
        return ruta;
    }
}
