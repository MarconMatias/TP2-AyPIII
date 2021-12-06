package edu.fiuba.algo3.modelo.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
      return leerCiudadesMap(new FileReader(ruta));
    } catch(IOException ex){
      ex.printStackTrace();
      throw new RuntimeException("Error al leer las ciudades:" + ex.getMessage());
    }
  }

  public ArrayList<Ciudad> leerCiudades(java.io.Reader lectorDatos)
  {
   return leerCiudades(lector.leerJsonMap(lectorDatos));
  }

  public Map<String,Ciudad> leerCiudadesMap(java.io.Reader lectorDatos) {
    return lector.mapear(leerCiudades(lectorDatos), ciudad -> ciudad.getNombre());
  }

  public ArrayList<Ciudad> leerCiudades(Map parseado) {
    ArrayList jsonCiudades = lector.leerPropiedadComo(ArrayList.class,parseado,"ciudades");
    return lector.interpetarArray(jsonCiudades, obj->interpretarCiudad(obj));
  }

  public Map<String,Ciudad> leerCiudadesMap(Map parseado) {
    return lector.mapear(leerCiudades(parseado),ciudad->ciudad.getNombre());
  }

  private Ciudad interpretarCiudad(Map ciudad) {
    String nombre = (String) ciudad.get("nombre");
    ArrayList<PistaCiudad> pistas = interprete.interpretar((JSONArray) ciudad.get("pistas"));
    return (new Ciudad(nombre, pistas));
  }

}
