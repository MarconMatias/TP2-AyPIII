package edu.fiuba.algo3.modelo.Lector;

import java.util.HashMap;

public class LectorJson {
    /**
     * Provee un casteo, arrojando un error claro si la propiedad no existe o no es de la clase esperada.
     * @param clase La clase a la que se castea.
     * @param objeto El objeto que debe tener la propiedad.
     * @param propiedad El nombre de la propiedad buscada en el objeto.
     * @param <T> La clase a la que se castea.
     * @return La propiedad `propiedad` de `objeto`.
     */
    public <T> T leerPropiedadComo(Class<T> clase, HashMap objeto, String propiedad) {
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
}
