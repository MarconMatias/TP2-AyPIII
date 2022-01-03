package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ciudad.Mapa;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroEconomia;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroHistoria;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroPais;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaDificil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaFacil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaMedia;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CoherenciaDataTest {
    @Test
    public void laCiudadDeCadaItemEstaEnCiudades() throws LectorException {
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
    public void todasLasCiudadesEstanEnMapa() throws LectorException {
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
    public void todasLasCiudadesTienenEntre3y4Salientes() throws LectorException {
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
    public void cadaCiudadTieneUnaPistaDeCadaDificultad() throws LectorException {
        final NivelPista facil = new PistaFacil();
        final NivelPista media = new PistaMedia();
        final NivelPista dificil = new PistaDificil();

        BiFunction<String,Collection<PistaCiudad>,Ciudad> constructor = Mockito.mock(BiFunction.class);
        Map<String, Collection<PistaCiudad>> llamadas = new HashMap<>();

        when(constructor.apply(anyString(),anyCollection())).then(invocacion -> {
            String nombre = invocacion.getArgument(0,String.class);
            Collection<PistaCiudad> pistas = invocacion.getArgument(1, Collection.class);
            llamadas.put(nombre,pistas);
            return new Ciudad(nombre, pistas);
        });

        LectorCiudad lector = new LectorCiudad(constructor);
        Collection<Ciudad> ciudades =  lector.leerCiudades().values();
        for(String nombre : llamadas.keySet()) {
            Collection<IPista> pistas = (Collection<IPista>)(Collection<?>) llamadas.get(nombre);
            Collection<IPista> faciles = facil.filtrarPistas(pistas);
            Collection<IPista> medias = media.filtrarPistas(pistas);
            Collection<IPista> dificiles = dificil.filtrarPistas(pistas);
            assertTrue(faciles.size() > 0, "Hay pistas fáciles en "+nombre);
            assertTrue(medias.size() > 0, "Hay pistas medias en "+nombre);
            assertTrue(dificiles.size() > 0, "Hay pistas difíciles en "+nombre);
        }
        assertEquals(ciudades.size(), llamadas.size());
    }

    @Test
    public void cadaCiudadConCadaFiltroTieneUnaPistaDeCadaDificultad() throws LectorException {
        final List<IFiltroCiudad> filtros = List.of(
                new FiltroEconomia(), new FiltroPais(), new FiltroHistoria());
        final NivelPista facil = new PistaFacil();
        final NivelPista media = new PistaMedia();
        final NivelPista dificil = new PistaDificil();

        BiFunction<String,Collection<PistaCiudad>,Ciudad> constructor = Mockito.mock(BiFunction.class);
        Map<String, Collection<PistaCiudad>> llamadas = new HashMap<>();

        when(constructor.apply(anyString(),anyCollection())).then(invocacion -> {
            String nombre = invocacion.getArgument(0,String.class);
            Collection<PistaCiudad> pistas = invocacion.getArgument(1, Collection.class);
            llamadas.put(nombre,pistas);
            return new Ciudad(nombre, pistas);
        });

        LectorCiudad lector = new LectorCiudad(constructor);
        Collection<Ciudad> ciudades =  lector.leerCiudades().values();
        for(String nombre : llamadas.keySet()) {
            Collection pistas = (Collection<IPista>)(Collection<?>) llamadas.get(nombre);
            for(IFiltroCiudad filtro : filtros) {
                List filtradas = filtro.filtrarPistas(pistas);
                Collection<IPista> faciles = facil.filtrarPistas(filtradas);
                Collection<IPista> medias = media.filtrarPistas(filtradas);
                Collection<IPista> dificiles = dificil.filtrarPistas(filtradas);
                String textoFiltro = " con "+filtro.getClass().getSimpleName();
                assertTrue(faciles.size() > 0, "Hay pistas fáciles en "+nombre+textoFiltro);
                assertTrue(medias.size() > 0, "Hay pistas medias en "+nombre+textoFiltro);
                assertTrue(dificiles.size() > 0, "Hay pistas difíciles en "+nombre+textoFiltro);
            }
        }
        assertEquals(ciudades.size(), llamadas.size());
    }

    @Test
    public void alLeerCiudadesNingunaPistaEstaVacia() throws LectorException {
        BiFunction<String,Collection<PistaCiudad>,Ciudad> constructor = Mockito.mock(BiFunction.class);
        Map<String, Collection<PistaCiudad>> llamadas = new HashMap<>();

        when(constructor.apply(anyString(),anyCollection())).then(invocacion -> {
            String nombre = invocacion.getArgument(0,String.class);
            Collection<PistaCiudad> pistas = invocacion.getArgument(1, Collection.class);
            llamadas.put(nombre,pistas);
            return new Ciudad(nombre, pistas);
        });
        LectorCiudad lector = new LectorCiudad(constructor);
        Collection<Ciudad> ciudades =  lector.leerCiudades().values();
        for(String nombre : llamadas.keySet()) {
            for(PistaCiudad pista : llamadas.get(nombre)) {
                assertNotEquals("", pista.getValor(), "No hay pistas vacías en "+nombre + "("+pista+")");
            }
        }
    }

    @Test
    public void alFiltrarPorNivelYFiltroNoQuedaPistaSinUsar() throws LectorException {
        final List<IFiltroCiudad> filtros = List.of(
                new FiltroEconomia(), new FiltroPais(), new FiltroHistoria());
        final NivelPista facil = new PistaFacil();
        final NivelPista media = new PistaMedia();
        final NivelPista dificil = new PistaDificil();

        BiFunction<String,Collection<PistaCiudad>,Ciudad> constructor = Mockito.mock(BiFunction.class);
        Map<String, Collection<PistaCiudad>> llamadas = new HashMap<>();

        when(constructor.apply(anyString(),anyCollection())).then(invocacion -> {
            String nombre = invocacion.getArgument(0,String.class);
            Collection<PistaCiudad> pistas = invocacion.getArgument(1, Collection.class);
            llamadas.put(nombre,pistas);
            return new Ciudad(nombre, pistas);
        });

        LectorCiudad lector = new LectorCiudad(constructor);
        lector.leerCiudades();
        for(String nombre : llamadas.keySet()) {
            Collection pistas = (Collection<IPista>)(Collection<?>) llamadas.get(nombre);
            for(IFiltroCiudad filtro : filtros) {
                List filtradas = filtro.filtrarPistas(pistas);
                Collection<IPista> faciles = facil.filtrarPistas(filtradas);
                filtradas.removeAll(faciles);
                pistas.removeAll(faciles);
                Collection<IPista> medias = media.filtrarPistas(filtradas);
                filtradas.removeAll(medias);
                pistas.removeAll(medias);
                Collection<IPista> dificiles = dificil.filtrarPistas(filtradas);
                filtradas.removeAll(dificiles);
                pistas.removeAll(dificiles);
                String textoFiltro = " con "+filtro.getClass().getSimpleName();
                assertEquals(0,filtradas.size(),
                        "No hay pistas sin nivel en "+nombre+textoFiltro
                                +", ej.:"+filtradas.stream().findAny().orElse(null));
            }
            assertEquals(0,pistas.size(),
                    "No hay pistas sin nivel ni filtro en "+nombre
                            +", ej.:"+pistas.stream().findAny().orElse(null));
        }
    }

    @Test
    public void cadaCiudadTieneDetalles() throws LectorException {
        LectorCiudad lectorCiudad = new LectorCiudad();
        Map<String,Ciudad> ciudades = lectorCiudad.leerCiudades();
        for(Ciudad ciudad : ciudades.values()) {
            assertNotNull(ciudad.getDescripcion(), ciudad.getNombre());
            assertNotEquals("",ciudad.getDescripcion().trim(), ciudad.getNombre());
        }
    }
}
