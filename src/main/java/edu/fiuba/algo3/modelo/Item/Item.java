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

    public String getNombre() {
        return nombreDelItem;
    }

    public String getNombreCiudadDelRobo() {
        return nombreCiudadDelRobo;
    }
    public Ciudad getCiudadDelRobo(Mapa mapa) {
        return mapa.getCiudadPorNombre(nombreCiudadDelRobo);
    }

    public List<Ciudad> getRuta(Mapa mapa, Random random) {
        /** \todo Usar nivelItem. **/
        List<Ciudad> ruta = new ArrayList<>(List.of(getCiudadDelRobo(mapa)));
        while(ruta.size() < 4) {
            mapa.agregarSiguiente(ruta,random);
        }
        return ruta;
    }
}
