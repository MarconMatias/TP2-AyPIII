package edu.fiuba.algo3.modelo.Lector;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class LectorJson {
    /**
     * Provee un casteo, arrojando un error claro si la propiedad no existe o no es de la clase esperada.
     * @param clase La clase a la que se castea.
     * @param objeto El objeto que debe tener la propiedad.
     * @param propiedad El nombre de la propiedad buscada en el objeto.
     * @param <T> La clase a la que se castea.
     * @return La propiedad `propiedad` de `objeto`.
     */
    public <T> T leerPropiedadComo(Class<T> clase, Map objeto, String propiedad) {
        if(!objeto.containsKey(propiedad))
        {
            throw new RuntimeException("No contiene propiedad " + propiedad + ".");
        }
        Object valor = objeto.get(propiedad);
        if(!clase.isInstance(valor))
        {
            throw new RuntimeException("La propiedad " + propiedad + " no es "+clase.getName()+".");
        }
        return clase.cast(valor);
    }

    private Map comoDiccionario(Object elemento)
    {
        if(!(elemento instanceof Map)) {
            throw new RuntimeException("No es un diccionario.");
        }
        return (Map) elemento;
    }

    public <T> ArrayList<T> interpetarArray(ArrayList array, Function<Map,T> iterpretar)
    {
        ArrayList<T> lista = new ArrayList<T>();
        int i = 0;
        for(Object elemento:array)
            try {
                lista.add(iterpretar.apply(comoDiccionario(elemento)));
                i++;
            } catch (RuntimeException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Error al leer elemento "+i+": "+ex.getMessage());
            }
        return lista;
    }

    public <T,S> Map<S,T> mapear(List<T> lista, Function<T,S> conversorALlave)
    {
        Map<S,T> map = new HashMap<S,T>();
        for(T elemento : lista)
        {
            map.put(conversorALlave.apply(elemento), elemento);
        }
        return map;
    }
}
