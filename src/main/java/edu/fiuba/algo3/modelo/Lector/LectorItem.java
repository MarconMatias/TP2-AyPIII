package edu.fiuba.algo3.modelo.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

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
}
