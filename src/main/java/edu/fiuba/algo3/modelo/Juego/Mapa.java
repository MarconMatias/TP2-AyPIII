package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Ciudad.CiudadVisitada;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.*;
import java.util.stream.Collectors;

public class Mapa {

    private Map<String, Map<String, Integer>> origenes = new HashMap<String,Map<String,Integer>>();

    public CiudadVisitada viajarHacia(Policia policiaDeLaMision, Calendario calendario, String nombreDeLaCiudadDestino) {
        return null;
    }

    public void viajar(Policia policia, String origen, String destino, Calendario calendario) {
        if(!origenes.containsKey(origen))
        {
            throw new RuntimeException("El origen no existe en el mapa.");
        }
        Map<String,Integer> destinos = origenes.get(origen);
        if(!destinos.containsKey(destino))
        {
            throw new RuntimeException("El destino no existe en el mapa con ese origen.");
        }
        Integer distancia = destinos.get(destino);
        policia.viajar(distancia, calendario);
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
}
