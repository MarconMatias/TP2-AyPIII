package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorLadron {
  LectorJson lector = new LectorJson();
  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();

  public ArrayList<Ladron> leerLadrones() {
    return leerLadrones(lector.leerJsonMap("/edu/fiuba/algo3/expediente.json"));
  }


  public ArrayList<Ladron> leerLadrones(Map entrada) {
    JSONArray jsonLadrones = lector.leerPropiedadComo(JSONArray.class, entrada, "ladrones");
    ArrayList<Ladron> ladrones = lector.interpetarArray(jsonLadrones, this::interpretarLadron);
    return ladrones;
  }

  public Ladron interpretarLadron(Map jsonLadron) {
    String nombre = lector.leerPropiedadComo(String.class,jsonLadron,"nombre");
    Map<String,String> detalles = new HashMap<String,String>();
    for(String tipo : List.of("sexo", "deporte", "cabello", "distincion", "vehiculo"))
    {
      String detalle = lector.leerPropiedadComo(String.class, jsonLadron, tipo);
      if(null == detalle) {
        detalle = "Desconocido";
      }
      detalles.put(tipo, detalle);
    }
    return new Ladron(nombre,detalles);
  }
}
