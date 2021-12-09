package edu.fiuba.algo3.modelo.Lector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import org.json.simple.JSONArray;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

public class LectorCiudad {
  LectorJson lector = new LectorJson();
  InterpretePistaCiudad interprete = new InterpretePistaCiudad();

  public Map<String,Ciudad> leerCiudades() {
    return leerCiudadesMap("src/main/java/edu/fiuba/algo3/recursos/ciudades.json");
  }

  public List<Ciudad> leerCiudades(String ruta)
  {
    return leerCiudades(lector.leerJsonMap(ruta));
  }

  public Map<String,Ciudad> leerCiudadesMap(String ruta) {
    return lector.mapear(leerCiudades(ruta), Ciudad::getNombre);
  }

  public ArrayList<Ciudad> leerCiudades(java.io.Reader lectorDatos)
  {
    return leerCiudades(lector.leerJsonMap(lectorDatos));
  }

  public Map<String,Ciudad> leerCiudadesMap(java.io.Reader lectorDatos) {
    return lector.mapear(leerCiudades(lectorDatos), Ciudad::getNombre);
  }

  public ArrayList<Ciudad> leerCiudades(Map parseado) {
    ArrayList jsonCiudades = lector.leerPropiedadComo(ArrayList.class,parseado,"ciudades");
    return lector.interpetarArray(jsonCiudades, this::interpretarCiudad);
  }

  public Map<String,Ciudad> leerCiudadesMap(Map parseado) {
    return lector.mapear(leerCiudades(parseado), Ciudad::getNombre);
  }

  private Ciudad interpretarCiudad(Map ciudad) {
    String nombre = (String) ciudad.get("nombre");
    ArrayList<PistaCiudad> pistas = interprete.interpretar((JSONArray) ciudad.get("pistas"));
    return (new Ciudad(nombre, pistas));
  }

}