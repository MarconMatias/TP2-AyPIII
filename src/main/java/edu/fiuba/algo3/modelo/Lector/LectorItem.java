package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Item.Item;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Map;

public class LectorItem {
  LectorJson lector = new LectorJson();

  public ArrayList<Item> leerItems() throws LectorException {
    return leerItems(lector.leerJsonMap("/edu/fiuba/algo3/items.json"));
  }

  public ArrayList<Item> leerItems(Map entrada) throws LectorException {
    ArrayList jsonItems = lector.leerPropiedadComo(JSONArray.class,entrada,"items");
    return lector.interpetarArray(jsonItems, this::interpretarItem);
  }

  public Item interpretarItem(Map jsonItem) throws LectorException {
    String nombre = lector.leerPropiedadComo(String.class,jsonItem,"nombre");
    String ciudad = lector.leerPropiedadComo(String.class,jsonItem,"ciudad");
    return new Item(nombre,ciudad);
  }
}
