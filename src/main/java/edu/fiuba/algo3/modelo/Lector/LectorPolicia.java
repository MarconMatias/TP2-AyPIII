package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Policia.Policia;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Map;

public class LectorPolicia {

  LectorJson lector = new LectorJson();

  public ArrayList<Policia> leerPolicias() {
    return leerPolicias(lector.leerJsonMap("/edu/fiuba/algo3/agentes.json"));
  }

  public ArrayList<Policia> leerPolicias(Map entrada) {
    ArrayList jsonAgentes = lector.leerPropiedadComo(JSONArray.class, entrada, "agentes");
    return lector.interpetarArray(jsonAgentes, this::interpretarItem);
  }

  public Policia interpretarItem(Map jsonAgente) {
    String nombre = lector.leerPropiedadComo(String.class, jsonAgente, "nombre");
    Number arrestos = lector.leerPropiedadComo(Number.class, jsonAgente, "arrestos");
    return new Policia(nombre, arrestos.intValue());
  }
}
