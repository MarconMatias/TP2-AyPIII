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

  InterpretePistaCiudad interprete = new InterpretePistaCiudad();
  ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

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

  private JSONArray leerPropiedadComoArray(JSONObject objeto,String propiedad)
  {
    Object valor =objeto.getOrDefault(propiedad,null);
    if(!(valor instanceof JSONArray))
    {
      throw new RuntimeException("Error en ciudades, no se encontró array " + propiedad);
    }
    return (JSONArray) valor;
  }

  public Map<String,Ciudad> leerCiudades(JSONObject parseado) {
    JSONArray ciudades = leerPropiedadComoArray(parseado,"ciudades");
    Map<String,Ciudad> dicc = new HashMap<String,Ciudad>();
    int i=0;
    for(Object elemento : ciudades)
    {
      String nombre = "";
      ArrayList<PistaCiudad> pistas = new ArrayList<>();
      dicc.put(nombre,new Ciudad(nombre,pistas));
      i++;
    }
    return dicc;
  }
/*
  public ArrayList<Ciudad> leerCiudadesDeArchivo(String nombreArchivo) {

    JSONParser parser = new JSONParser();

    try (Reader reader = new FileReader(nombreArchivo)) {

      JSONObject json = (JSONObject) parser.parse(reader);
      JSONArray ciudadesJson = (JSONArray) json.get("ciudades");
      Iterator<JSONObject> iterator = ciudadesJson.iterator();
      while (iterator.hasNext()) {
        ciudades.add(interpretarCiudad(iterator.next()));
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (org.json.simple.parser.ParseException e) {
      e.printStackTrace();
    }
    return ciudades;
  }

  private Ciudad interpretarCiudad(JSONObject ciudad) {
    return (new Ciudad((String) ciudad.get("nombre"), interprete.interpretar((JSONArray) ciudad.get("pistas"))));
  }
*/
}
