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

  ArrayList<Item> items = new ArrayList<Item>();

  public ArrayList<Item> leerItems() {

    JSONParser parser = new JSONParser();

    try (Reader reader = new FileReader("/src/main/java/edu/fiuba/algo3/recursos/items.json")) {

      JSONObject json = (JSONObject) parser.parse(reader);
      JSONArray itemsJson = (JSONArray) json.get("items");
      Iterator<JSONObject> iterator = itemsJson.iterator();
      while (iterator.hasNext()) {
        items.add(new Item((String) (iterator.next()).get("nombre"), (String) (iterator.next()).get("ciudad")));
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (org.json.simple.parser.ParseException e) {
      e.printStackTrace();
    }
    return items;
  }

  private JSONObject comoDiccionario(Object elemento)
  {
    if(!(elemento instanceof JSONObject)) {
      throw new RuntimeException("No es un diccionario.");
    }
    return (JSONObject) elemento;
  }

  private JSONArray leerPropiedadComoArray(HashMap objeto, String propiedad) {
    Object valor = objeto.getOrDefault(propiedad,null);
    if(!(valor instanceof JSONArray))
    {
      throw new RuntimeException("No contiene propiedad " + propiedad + " o no es un array.");
    }
    return (JSONArray) valor;
  }

  private String leerPropiedadComoString(HashMap objeto, String propiedad) {
    Object valor = objeto.getOrDefault(propiedad,null);
    if(!(valor instanceof String))
    {
      throw new RuntimeException("No contiene propiedad " + propiedad + " o no es un string.");
    }
    return (String) valor;
  }

  public List<Item> leerItems(JSONObject entrada) {
    JSONArray jsonItems = leerPropiedadComoArray(entrada,"items");
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
    String nombre = leerPropiedadComoString(jsonItem,"nombre");
    String ciudad = "";
    return new Item(nombre,ciudad);
  }
}
