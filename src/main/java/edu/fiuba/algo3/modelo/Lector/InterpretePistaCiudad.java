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
    int i=0;
    for(Object elemento:listaPistas)
    {
      if(!(elemento instanceof JSONObject))
      {
        throw new RuntimeException("El elemento en la posición "+i+" no es un diccionario.");
      }
      JSONObject dicc = (JSONObject) elemento;
      if(!dicc.containsKey("tipo")||!dicc.containsKey("pista"))
      {
        throw new RuntimeException("El elemento en la posición "+i+" no tiene el formato correcto.");
      }
      String tipo = dicc.get("tipo").toString();
      String pista = dicc.get("pista").toString();
      int dificultad = ((Number) dicc.get("dificultad")).intValue();
      NivelPista nivel = InterpreteNivelPista.crearConDificultad(dificultad);
      pistas.add(new PistaCiudad(tipo, pista,nivel));
      i++;
    }
    return pistas;
  }
}
