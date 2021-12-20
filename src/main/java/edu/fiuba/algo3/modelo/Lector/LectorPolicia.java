package edu.fiuba.algo3.modelo.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.fiuba.algo3.modelo.Policia.Policia;

public class LectorPolicia {

  LectorJson lector = new LectorJson();

  public ArrayList<Policia> leerPolicias() {

    JSONParser parser = new JSONParser();

    try (Reader reader = new FileReader("/src/main/java/edu/fiuba/algo3/recursos/agentes.json")) {

      JSONObject json = (JSONObject) parser.parse(reader);
      return leerPolicias(json);
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException("No pudo leerse el archivo de items: " + ex.getMessage());
    } catch (org.json.simple.parser.ParseException ex) {
      ex.printStackTrace();
      throw new RuntimeException("No pudo parsearse el archivo de items: " + ex.getMessage());
    }
  }

  public ArrayList<Policia> leerPolicias(JSONObject entrada) {
    ArrayList jsonAgentes = lector.leerPropiedadComo(JSONArray.class, entrada, "agentes");
    return lector.interpetarArray(jsonAgentes, obj -> interpretarItem(obj));
  }

  public Policia interpretarItem(Map jsonAgente) {
    String nombre = lector.leerPropiedadComo(String.class, jsonAgente, "nombre");
    Number arrestos = lector.leerPropiedadComo(Number.class, jsonAgente, "arrestos");
    return new Policia(nombre, (int) arrestos);
  }
}
