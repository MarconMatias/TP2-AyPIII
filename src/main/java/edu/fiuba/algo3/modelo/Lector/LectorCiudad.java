package edu.fiuba.algo3.modelo.Lector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

public class LectorCiudad {

  InterpretePistaCiudad interprete = new InterpretePistaCiudad();
  ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

  public ArrayList<Ciudad> leerCiudades() {

    JSONParser parser = new JSONParser();

    try (Reader reader = new FileReader("/src/main/java/edu/fiuba/algo3/recursos/ciudades.json")) {

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

  private Ciudad interpretarCiudad(String ciudad) {
    // return (Ciudad ciudad = new Ciudad(ciudad.nombre,
    // interprete.interpretar(listaPistas) ));
    return null;
  }

}
