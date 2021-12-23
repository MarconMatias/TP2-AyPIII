package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.Mapa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoherenciaDataTest {
    @Test
    public void laCiudadDeCadaItemEstaEnCiudades() {
        LectorItem lectorItems = new LectorItem();
        LectorCiudad lectorCiudad = new LectorCiudad();
        List<Item> items = lectorItems.leerItems();
        Map<String, Ciudad> ciudades = lectorCiudad.leerCiudades();
        List<Item> itemsSinCiudad = new ArrayList<>();
        for(Item item: items) {
            String nombreCiudad = item.getNombreCiudadDelRobo();
            if(!ciudades.containsKey(nombreCiudad)) {
                itemsSinCiudad.add(item);
                System.err.println("Item "+item+", ciudad "+nombreCiudad+" no está en ciudades.");
            }
        }
        assertEquals(0, itemsSinCiudad.size());
    }

    @Test
    public void todasLasCiudadesEstanEnMapa() {
        LectorCiudad lectorCiudad = new LectorCiudad();
        LectorMapa lectorMapa = new LectorMapa();
        Map<String, Ciudad> ciudades = lectorCiudad.leerCiudades();
        Mapa mapa = new Mapa(ciudades);
        lectorMapa.leerMapa(mapa);
        List<Ciudad> sinConexionSaliente = new ArrayList<>();
        for(Ciudad ciudad : ciudades.values()) {
            try {
                List<Ciudad> vecinas = mapa.getCiudadesVecinas(ciudad);
                if(null == vecinas) {
                    sinConexionSaliente.add(ciudad);
                    System.err.println(ciudad.getNombre() + " vecinas es null");
                } else if (0 == vecinas.size()) {
                    sinConexionSaliente.add(ciudad);
                    System.err.println(ciudad.getNombre() + " tiene 0 vecinas");
                }
            } catch (RuntimeException ex) {
                System.err.println(ciudad.getNombre() + " da error "+ex);
                sinConexionSaliente.add(ciudad);
            }
        }
        assertEquals(0, sinConexionSaliente.size());
    }

    @Test
    public void todasLasCiudadesTienenEntre3y4Salientes() {
        LectorCiudad lectorCiudad = new LectorCiudad();
        LectorMapa lectorMapa = new LectorMapa();
        Map<String, Ciudad> ciudades = lectorCiudad.leerCiudades();
        Mapa mapa = new Mapa(ciudades);
        lectorMapa.leerMapa(mapa);
        List<Ciudad> conFallas = new ArrayList<>();
        for(Ciudad ciudad : ciudades.values()) {
            try {
                int cantidad = mapa.getCiudadesVecinas(ciudad).size();
                if((cantidad<3)||(cantidad>4)) {
                    conFallas.add(ciudad);
                    System.err.println(ciudad.getNombre() + " tiene "+cantidad+" conexiones salientes");
                }
            } catch (RuntimeException ex) {
                System.err.println(ciudad.getNombre() + " da error "+ex);
                conFallas.add(ciudad);
            }
        }
        assertEquals(0, conFallas.size());
    }


}