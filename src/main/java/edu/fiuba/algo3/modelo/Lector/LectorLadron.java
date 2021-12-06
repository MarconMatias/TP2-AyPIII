package edu.fiuba.algo3.modelo.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class LectorLadron {

  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();

  public ArrayList<Ladron> leerLadrones() {

    JSONParser parser = new JSONParser();

    try (Reader reader = new FileReader("/src/main/java/edu/fiuba/algo3/recursos/expediente.json")) {

      JSONObject json = (JSONObject) parser.parse(reader);
      JSONArray expedienteJson = (JSONArray) json.get("items");
      Iterator<JSONObject> iterator = expedienteJson.iterator();
      while (iterator.hasNext()) {
        ladrones.add(new Ladron((String) (iterator.next()).get("nombre"), (String) (iterator.next()).get("sexo"),
            (String) (iterator.next()).get("deporte"), (String) (iterator.next()).get("cabello"),
            (String) (iterator.next()).get("distincion"), (String) (iterator.next()).get("vehiculo")));
      }

    } catch (IOException e) {
      e.printStackTrace();
    } catch (org.json.simple.parser.ParseException e) {
      e.printStackTrace();
    }
    return ladrones;
  }

  private JSONObject comoDiccionario(Object elemento)
  {
    if(!(elemento instanceof JSONObject)) {
      throw new RuntimeException("No es un diccionario.");
    }
    return (JSONObject) elemento;
  }

  /**
   * Provee un casteo, arrojando un error claro si la propiedad no existe o no es de la clase esperada.
   * @param clase La clase a la que se castea.
   * @param objeto El objeto que debe tener la propiedad.
   * @param propiedad El nombre de la propiedad buscada en el objeto.
   * @param <T> La clase a la que se castea.
   * @return La propiedad `propiedad` de `objeto`.
   */
  private <T> T leerPropiedadComo(Class<T> clase, HashMap objeto, String propiedad) {
    if(!objeto.containsKey(propiedad))
    {
      throw new RuntimeException("No contiene propiedad " + propiedad + ".");
    }
    Object valor = objeto.get(propiedad);
    if(!clase.isInstance(valor))
    {
      throw new RuntimeException("La propiedad " + propiedad + " no es "+clase.getName()+".");
    }
    return clase.cast(valor);
  }

  public List<Ladron> leerLadrones(JSONObject entrada) {
    ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
    JSONArray jsonLadrones = leerPropiedadComo(JSONArray.class, entrada, "ladrones");
    int i = 0;
    for(Object elemento:jsonLadrones)
      try {
        ladrones.add(interpretarLadron(comoDiccionario(elemento)));
        i++;
      } catch (RuntimeException ex) {
        ex.printStackTrace();
        throw new RuntimeException("Error al leer ladrón "+i+": "+ex.getMessage());
      }
    return ladrones;
  }

  private Ladron interpretarLadron(JSONObject comoDiccionario) {
    String nombre = "";
    String sexo = "";
    String deporte = "";
    String cabello = "";
    String distincion = "";
    String vehiculo = "";
    return new Ladron(nombre,sexo,deporte,cabello,distincion,vehiculo);
  }
}
