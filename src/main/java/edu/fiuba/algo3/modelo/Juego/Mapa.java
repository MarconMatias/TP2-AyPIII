package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.*;
import java.util.stream.Collectors;

public class Mapa {

    private final Map<String, Map<String, Integer>> origenes;
    private Map<String, Ciudad> ciudadesPorNombre;

    public Mapa(Map<String, Ciudad> ciudadesPorNombre)
    {
        origenes = new HashMap<String,Map<String,Integer>>();
        this.ciudadesPorNombre = ciudadesPorNombre;
    }

    public List<String> getCiudadesVecinas(Ciudad origen) {
        if(!origenes.containsKey(origen.getNombre()))
        {
            throw new RuntimeException("El origen no existe en el mapa.");
        }
        Map<String,Integer> destinos = origenes.get(origen.getNombre());
        return new ArrayList<>(destinos.keySet());
    }

    public Ciudad viajar(Policia policia, Ciudad origen, String destino) {
        if(!origenes.containsKey(origen.getNombre()))
        {
            throw new RuntimeException("El origen no existe en el mapa.");
        }
        Map<String,Integer> destinos = origenes.get(origen.getNombre());
        if(!destinos.containsKey(destino))
        {
            throw new RuntimeException("El destino no existe en el mapa con ese origen.");
        }
        Ciudad destinoCiudad = getCiudadPorNombre(destino);
        Integer distancia = destinos.get(destino);
        policia.viajar(distancia);
        destinoCiudad.visitadaPorPolicia(policia);
        return destinoCiudad;
    }

    public void agregarConexion(String origen, String destino, int distanciaKm) {
        Map<String,Integer> destinos;
        if(origenes.containsKey(origen)) {
            destinos = origenes.get(origen);
        } else {
            destinos = new HashMap<>();
            origenes.put(origen,destinos);
        }
        destinos.put(destino,distanciaKm);
    }

    public List<String> getOrigenes() {
        ArrayList<String> lista = new ArrayList<>(origenes.keySet());
        Collections.sort(lista);
        return lista;
    }

    public Ciudad getCiudadPorNombre(String nombreCiudad) {
        return ciudadesPorNombre.get(nombreCiudad);
    }

    public void agregarSiguiente(List<String> ruta, Random random) {
        String ultima = ruta.get(ruta.size()-1);
        List<String> destinos = origenes.get(ultima).keySet().stream().
                filter(destino -> !ruta.contains(destino)).collect(Collectors.toList());
        int indice = random.nextInt(destinos.size());
        String siguiente = destinos.get(indice);
        ruta.add(siguiente);
    }

}
