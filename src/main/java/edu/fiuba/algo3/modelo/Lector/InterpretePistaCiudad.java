package edu.fiuba.algo3.modelo.Lector;

import java.util.ArrayList;
import java.util.Iterator;

import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

public class InterpretePistaCiudad {

  ArrayList<PistaCiudad> pistas = new ArrayList<PistaCiudad>();

  public ArrayList<PistaCiudad> interpretar(JSONArray listaPistas) {

    Iterator<JSONObject> iterator = listaPistas.iterator();
    while (iterator.hasNext()) {
      String tipo = (String) (iterator.next()).get("tipo");
      String pista = (String) (iterator.next()).get("pista");
      int dificultad = (int) (iterator.next()).get("dificultad");
      NivelPista nivel = InterpreteNivelPista.crearConDificultad(dificultad);
      pistas.add(new PistaCiudad(tipo, pista,nivel));
    }
    return null;
  }
}
