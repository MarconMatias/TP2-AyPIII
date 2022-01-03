package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Mapa;

import java.util.Map;

public class LectorMapa {
    LectorJson lectorJson = new LectorJson();

    public LectorMapa() {
    }
    public Mapa leerMapa(Map entrada, Mapa mapa) throws LectorException {
        Map mapaJson = lectorJson.leerPropiedadComo(Map.class,entrada,"mapa");
        for (Object clave:mapaJson.keySet()) {
            if(!(clave instanceof String))
            {
                throw new RuntimeException("Hay un origen que no es String, es "+clave.getClass().getName()+": "+clave.toString());
            }
            String origen = (String) clave;
            Map destinosJson = lectorJson.leerPropiedadComo(Map.class,mapaJson,origen);
            interpretarOrigen(origen,destinosJson,mapa);
        }
        return mapa;
    }

    private void interpretarOrigen(String origen, Map destinosJson, Mapa mapa) throws LectorException {
        for (Object clave:destinosJson.keySet()) {
            if (!(clave instanceof String)) {
                throw new RuntimeException("En " + origen + " hay un destino que no es String, es " + clave.getClass().getName() + ": " + clave.toString());
            }
            String destino = (String) clave;
            int distancia = lectorJson.leerPropiedadComo(Number.class,destinosJson,destino).intValue();
            mapa.agregarConexion(origen, destino, distancia);
        }
    }

    public Mapa leerMapa(Mapa mapa) throws LectorException {
        return leerMapa("/edu/fiuba/algo3/mapa.json", mapa);
    }

    private Mapa leerMapa(String ruta, Mapa mapa) throws LectorException {
        return leerMapa(lectorJson.leerJsonMap(ruta), mapa);
    }
}
