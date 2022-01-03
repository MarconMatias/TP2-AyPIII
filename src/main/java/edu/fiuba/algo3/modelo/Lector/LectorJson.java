package edu.fiuba.algo3.modelo.Lector;

import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorJson {
    /**
     * Provee un casteo, arrojando un error claro si la propiedad no existe o no es de la clase esperada.
     *
     * @param clase     La clase a la que se castea.
     * @param objeto    El objeto que debe tener la propiedad.
     * @param propiedad El nombre de la propiedad buscada en el objeto.
     * @param <T>       La clase a la que se castea.
     * @return La propiedad `propiedad` de `objeto`.
     */
    public <T> T leerPropiedadComo(Class<T> clase, Map objeto, String propiedad) throws LectorException {
        if (!objeto.containsKey(propiedad)) {
            throw new LectorException("No contiene propiedad " + propiedad + ".");
        }
        Object valor = objeto.get(propiedad);
        if (!clase.isInstance(valor)) {
            throw new LectorException("La propiedad " + propiedad + " no es " + clase.getName() + ".");
        }
        return clase.cast(valor);
    }

    /**
     * Provee un casteo, devolviendo un valor por defecto si la propiedad no existe
     * o no es de la clase esperada.
     * @param clase La clase a la que se castea.
     * @param objeto El objeto que debe tener la propiedad.
     * @param propiedad El nombre de la propiedad buscada en el objeto.
     * @param porDefecto Valor por defecto si no existe la propiedad o no es de la clase dada.
     * @param <T> La clase a la que se castea.
     * @return La propiedad `propiedad` de `objeto`.
     */
    public <T> T leerPropiedadComo(Class<T> clase, Map objeto, String propiedad, T porDefecto) {
        if (!objeto.containsKey(propiedad)) {
            return porDefecto;
        }
        Object valor = objeto.get(propiedad);
        if (!clase.isInstance(valor)) {
            return porDefecto;
        }
        try {
            return clase.cast(valor);
        } catch(ClassCastException ex) {
            return porDefecto;
        }
    }

    public Map comoDiccionario(Object elemento) throws LectorException {
        if(!(elemento instanceof Map)) {
            throw new LectorException("No es un diccionario.");
        }
        return (Map) elemento;
    }

    public <T> ArrayList<T> interpetarArray(ArrayList array, JsonMapper<Map,T> iterpretar) throws LectorException {
        ArrayList<T> lista = new ArrayList<T>();
        List<Exception> internas = new ArrayList<>();
        int i = 0;
        for(Object elemento:array)
            try {
                lista.add(iterpretar.apply(comoDiccionario(elemento)));
                i++;
            } catch (RuntimeException ex) {
                internas.add(
                        new LectorException(
                                "Error al leer elemento "+i+": "+ex.getMessage(),
                                List.of(ex)));
            }
        if(1 == internas.size()) {
            try {
                throw internas.get(0);
            } catch (Exception e) {
                throw new LectorException(e.getMessage(),List.of(e));
            }
        } else if(internas.size()>1) {
            throw new LectorException("Varios errores al leer un diccionario.",internas);
        }
        return lista;
    }

    public Map leerJsonMap(java.io.Reader lectorDatos) throws LectorException {
        JSONParser parser = new JSONParser();
        try {
            return comoDiccionario(parser.parse(lectorDatos));
        } catch(IOException ex){
            ex.printStackTrace();
            throw new RuntimeException("Error de lectura:" + ex.getMessage());
        } catch(org.json.simple.parser.ParseException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error de interpretación:" + ex.getMessage());
        }
    }

    public Map leerJsonMap(String ruta) throws LectorException {
      try {
        InputStream stream = getClass().getResourceAsStream(ruta);
        Reader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        return leerJsonMap(reader);
      } catch(NullPointerException ex) {
        throw new LectorException("Error al leer el archivo "+ruta+": no se encuentra", ex);
      } catch(Exception ex) {
        throw new LectorException("Error al leer el archivo "+ruta+": "+ex, ex);
      }
    }

    @FunctionalInterface
    public interface JsonMapper<T, S> {
        S apply(T t) throws LectorException;
    }

    public <T,S> Map<S,T> mapear(List<T> lista, JsonMapper<T,S> conversorALlave) throws LectorException {
        List<Exception> internas = new ArrayList<>();
        int i=0;
        Map<S,T> map = new HashMap<S,T>();
        for(T elemento : lista)
        try {
            map.put(conversorALlave.apply(elemento), elemento);
            i++;
        } catch (RuntimeException ex) {
            internas.add(
                    new LectorException(
                            "Error al mapear elemento "+i+": "+ex.getMessage(),
                            List.of(ex)));
        }
        if(1 == internas.size()) {
            try {
                throw internas.get(0);
            } catch (Exception e) {
                throw new LectorException(e.getMessage(),e);
            }
        } else if(internas.size()>1) {
            throw new LectorException("Varios errores al mapear array.",internas);
        }
        return map;
    }
}
