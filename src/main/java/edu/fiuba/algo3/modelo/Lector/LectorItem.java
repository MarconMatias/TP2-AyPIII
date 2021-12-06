package edu.fiuba.algo3.modelo.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.fiuba.algo3.modelo.Item.Item;

public class LectorItem {

  public ArrayList<Item> leerItems() {

    JSONParser parser = new JSONParser();

    try (Reader reader = new FileReader("/src/main/java/edu/fiuba/algo3/recursos/items.json")) {

      JSONObject json = (JSONObject) parser.parse(reader);
      return leerItems(json);
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException("No pudo leerse el archivo de items: " + ex.getMessage());
    } catch (org.json.simple.parser.ParseException ex) {
      ex.printStackTrace();
      throw new RuntimeException("No pudo parsearse el archivo de items: " + ex.getMessage());
    }
  }

  private JSONObject comoDiccionario(Object elemento)
  {
    if(!(elemento instanceof JSONObject)) {
      throw new RuntimeException("No es un diccionario.");
    }
    return (JSONObject) elemento;
  }

  /**
   * Provee un casteo, arrojando un error claro si la propiedad no existe o no es de la clase esperada.
   * @param clase La clase a la que se castea.
   * @param objeto El objeto que debe tener la propiedad.
   * @param propiedad El nombre de la propiedad buscada en el objeto.
   * @param <T> La clase a la que se castea.
   * @return La propiedad `propiedad` de `objeto`.
   */
  private <T> T leerPropiedadComo(Class<T> clase, HashMap objeto, String propiedad) {
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

  public ArrayList<Item> leerItems(JSONObject entrada) {
    JSONArray jsonItems = leerPropiedadComo(JSONArray.class,entrada,"items");
    ArrayList<Item> items = new ArrayList<Item>();
    int i=0;
    for(Object elemento:jsonItems)
    try {
      items.add(interpretarItem(comoDiccionario(elemento)));
      i++;
    } catch (RuntimeException ex) {
      ex.printStackTrace();
      throw new RuntimeException("Error al leer elemento "+i+": "+ex.getMessage());
    }
    return items;
  }

  public Item interpretarItem(JSONObject jsonItem)
  {
    String nombre = leerPropiedadComo(String.class,jsonItem,"nombre");
    String ciudad = leerPropiedadComo(String.class,jsonItem,"ciudad");
    return new Item(nombre,ciudad);
  }
}
