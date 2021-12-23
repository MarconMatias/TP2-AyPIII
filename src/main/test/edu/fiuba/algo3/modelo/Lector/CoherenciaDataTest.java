package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.Mapa;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import edu.fiuba.algo3.vista.Ciudad.FotoCiudad;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.thoughtworks.qdox.parser.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.framework;

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

    @Test
    public void cadaCiudadTieneUnaPistaDeCadaDificultad() throws org.json.simple.parser.ParseException {
        InterpretePistaCiudad interprete = new InterpretePistaCiudad();
        ArrayList<IPista> faciles = new ArrayList<IPista>();
        ArrayList<IPista> medias = new ArrayList<IPista>();
        ArrayList<IPista> dificiles = new ArrayList<IPista>();
        NivelPista facil = new PistaFacil();
        NivelPista media = new PistaMedia();
        NivelPista dificil = new PistaDificil();
        JSONArray entrada = null;
        Collection<PistaCiudad> pistas;
        String fuente = "src/main/java/edu/fiuba/algo3/recursos/ciudades.json";
        LectorCiudad lector = new LectorCiudad();
        List<Ciudad> ciudades =  lector.leerCiudades(fuente);
        for(Ciudad ciudad : ciudades){
            pistas = ciudad.getPistas();
            pistas.toString();
            assertEquals(12, pistas.size());
        }
    }

}
