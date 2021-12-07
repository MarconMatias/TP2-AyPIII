package edu.fiuba.algo3.modelo.Lector;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import org.json.simple.JSONObject;

public class LectorCiudad {

  InterpretePistaCiudad interprete = new InterpretePistaCiudad();

  public ArrayList<Ciudad> leerCiudades(JSONObject entrada) {

    // leer archivo
    // por cada ciudad llama a interpretarCiudad
    // agrega la ciudad a la lista
    // devuelve la lista

    // Brenda implementara:
    // BufferedReader lector = new BufferedReader(new
    // FileReader("src/main/java/edu/fiuba/algo3/model/Ciudad/ciudades.csv"));
    // try {
    // String row;
    // while ((row = lector.readLine()) != null) {
    // String[] data = row.split(";");
    // Ciudad nuevaCiduad = new Ciudad(data);
    // ciudades.add(nuevaCiduad);
    // }
    // } catch (IOException e) {
    // lector.close();
    // }
    // lector.close();
    // }

    return null;
  }

<<<<<<< HEAD
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

  private JSONArray leerPropiedadComoArray(HashMap objeto,String propiedad)
  {
    Object valor = objeto.getOrDefault(propiedad,null);
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
=======
  private Ciudad interpretarCiudad(String ciudad) {
    // return (Ciudad ciudad = new Ciudad(ciudad.nombre,
    // interprete.interpretar(listaPistas) ));
    return null;
>>>>>>> 98e67cf7bebb438f2023ea83de30f8ebb1031c8f
  }

}
