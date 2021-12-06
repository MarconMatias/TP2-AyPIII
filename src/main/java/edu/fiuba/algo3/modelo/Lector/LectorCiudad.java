package edu.fiuba.algo3.modelo.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

public class LectorCiudad {
  LectorJson lector = new LectorJson();
  InterpretePistaCiudad interprete = new InterpretePistaCiudad();

  public Map<String,Ciudad> leerCiudades() {
    return leerCiudades("/src/main/java/edu/fiuba/algo3/recursos/ciudades.json");
  }
  public Map<String,Ciudad> leerCiudades(String ruta) {
    try
    {
      return leerCiudades(new FileReader(ruta));
    } catch(IOException ex){
      ex.printStackTrace();
      throw new RuntimeException("Error al leer las ciudades:" + ex.getMessage());
    }
  }

  public Map<String,Ciudad> leerCiudades(java.io.Reader lector)
  {
    JSONParser parser = new JSONParser();
    try {
      return leerCiudades((JSONObject) parser.parse(lector));
    } catch(IOException ex){
      ex.printStackTrace();
      throw new RuntimeException("Error al leer las ciudades:" + ex.getMessage());
    } catch(org.json.simple.parser.ParseException ex) {
      ex.printStackTrace();
      throw new RuntimeException("Error al parsear las ciudades:" + ex.getMessage());
    }
  }

  public Map<String,Ciudad> leerCiudades(JSONObject parseado) {
    ArrayList ciudades = lector.leerPropiedadComo(ArrayList.class,parseado,"ciudades");
    Map<String,Ciudad> dicc = new HashMap<String,Ciudad>();
    int i=0;
    for(Object elemento : ciudades)
    try
    {
      if(!(elemento instanceof JSONObject)) {
        throw new RuntimeException("No es un diccionario.");
      }
      Ciudad ciudad = this.interpretarCiudad((JSONObject) elemento);
      dicc.put(ciudad.getNombre(),ciudad);
      i++;
    } catch(Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException("Ciudad "+i+":" + ex.getMessage());
    }
    return dicc;
  }

  private Ciudad interpretarCiudad(JSONObject ciudad) {
    String nombre = (String) ciudad.get("nombre");
    ArrayList<PistaCiudad> pistas = interprete.interpretar((JSONArray) ciudad.get("pistas"));
    return (new Ciudad(nombre, pistas));
  }

}
