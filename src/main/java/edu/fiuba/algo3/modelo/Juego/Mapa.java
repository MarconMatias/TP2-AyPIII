package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

import java.util.*;
import java.util.stream.Collectors;

public class Mapa {

    private final Map<Ciudad, Map<Ciudad, Integer>> origenes;
    private Map<String, Ciudad> ciudadesPorNombre;

    public Mapa(Map<String, Ciudad> ciudadesPorNombre) {
        origenes = new HashMap<Ciudad, Map<Ciudad, Integer>>();
        this.ciudadesPorNombre = ciudadesPorNombre;
    }

    private static Map<String, Ciudad> mapear(Collection<Ciudad> lista) {
        Map<String, Ciudad> map = new HashMap<>();
        for (Ciudad ciudad : lista) {
            map.put(ciudad.getNombre(), ciudad);
        }
        return map;
    }

    public Mapa(Collection<Ciudad> ciudades) {
        this(mapear(ciudades));
    }

    public List<Ciudad> getCiudadesVecinas(Ciudad origen) {
        if (!origenes.containsKey(origen)) {
            throw new RuntimeException("El origen no existe en el mapa.");
        }
        Map<Ciudad, Integer> destinos = origenes.get(origen);
        return new ArrayList<>(destinos.keySet());
    }

    public Ciudad viajar(Policia policia, Ciudad origen, Ciudad destino) {
        if (!origenes.containsKey(origen)) {
            throw new RuntimeException("El origen no existe en el mapa.");
        }
        Map<Ciudad, Integer> destinos = origenes.get(origen);
        if (!destinos.containsKey(destino)) {
            throw new RuntimeException("El destino no existe en el mapa con ese origen.");
        }
        Integer distancia = destinos.get(destino);
        policia.viajar(distancia);
        destino.visitadaPorPolicia(policia);
        return destino;
    }

    public void agregarConexion(Ciudad origen, Ciudad destino, int distanciaKm) {
        Map<Ciudad, Integer> destinos;
        if (origenes.containsKey(origen)) {
            destinos = origenes.get(origen);
        } else {
            destinos = new HashMap<>();
            origenes.put(origen, destinos);
        }
        destinos.put(destino, distanciaKm);
    }

    public void agregarConexion(String origen, String destino, int distanciaKm) {
        Ciudad ciudadOrigen = ciudadesPorNombre.get(origen);
        if (null == ciudadOrigen) {
            throw new RuntimeException("El origen " + origen + " no es una ciudad existente.");
        }
        Ciudad ciudadDestino = ciudadesPorNombre.get(destino);
        if (null == ciudadDestino) {
            throw new RuntimeException("El destino " + destino + " no es una ciudad existente.");
        }
        agregarConexion(ciudadOrigen, ciudadDestino, distanciaKm);
    }

    public List<Ciudad> getOrigenes() {
        ArrayList<Ciudad> lista = new ArrayList<>(origenes.keySet());
        Collections.sort(lista);
        return lista;
    }

    public Ciudad getCiudadPorNombre(String nombreCiudad) {
        return ciudadesPorNombre.get(nombreCiudad);
    }

    public void agregarSiguiente(List<Ciudad> ruta, Random random) {
        Ciudad ultima = ruta.get(ruta.size() - 1);
        List<Ciudad> destinos = origenes.get(ultima).keySet().stream().filter(destino -> !ruta.contains(destino))
                .collect(Collectors.toList());
        int indice = random.nextInt(destinos.size());
        Ciudad siguiente = destinos.get(indice);
        ruta.add(siguiente);
    }

}
