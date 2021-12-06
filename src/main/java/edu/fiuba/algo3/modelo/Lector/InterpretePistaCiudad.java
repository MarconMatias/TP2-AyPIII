package edu.fiuba.algo3.modelo.Lector;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

public class InterpretePistaCiudad {

  ArrayList<PistaCiudad> pistas = new ArrayList<PistaCiudad>();

  public ArrayList<PistaCiudad> interpretar(JSONArray listaPistas) {

    Iterator<JSONObject> iterator = listaPistas.iterator();
    while (iterator.hasNext()) {
      pistas.add(new PistaCiudad((String) (iterator.next()).get("tipo"), (String) (iterator.next()).get("pista"),
          (int) (iterator.next()).get("dificultad")));
    }
    return null;
  }
}
