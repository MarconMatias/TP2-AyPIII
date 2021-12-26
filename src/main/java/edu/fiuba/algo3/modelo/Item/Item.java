package edu.fiuba.algo3.modelo.Item;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.RangoItem.ItemComun;
import edu.fiuba.algo3.modelo.Item.RangoItem.RangoItem;
import edu.fiuba.algo3.modelo.Juego.Mapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Item {

    private final String nombreDelItem;
    private final String nombreCiudadDelRobo;
    private final RangoItem rango;

    public Item(String nombreDelItem, String nombreCiudadDelRobo, RangoItem rango){

        this.nombreDelItem = nombreDelItem;
        this.nombreCiudadDelRobo = nombreCiudadDelRobo;
        this.rango = rango;
    }

    public Item(String nombreDelItem, String nombreCiudadDelRobo) {
        this(nombreDelItem, nombreCiudadDelRobo, new ItemComun());
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
        Ciudad ciudadInicial = getCiudadDelRobo(mapa);
        if(null==ciudadInicial) {
            throw new RuntimeException("La ciudad inicial " + nombreCiudadDelRobo + " del ítem "+nombreDelItem+" no se encuentra en el mapa dado.");
        }
        List<Ciudad> ruta = new ArrayList<>(List.of(ciudadInicial));
        rango.ampliarRuta(ruta, mapa, random);
        return ruta;
    }

    public String getTextoDerrota() {
        return getNombre() + " no pudo ser devuelto a " + getNombreCiudadDelRobo() + ". ";
    }

    public String getTextoEnJuego() {
        return getNombre() + " ha sido robado de " + getNombreCiudadDelRobo() + ". ";
    }

    public String getTextoVictoria() {
        return getNombre() + " fue devuelto a " + getNombreCiudadDelRobo() + ". ";
    }

}
