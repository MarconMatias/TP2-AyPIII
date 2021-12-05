package edu.fiuba.algo3.modelo.Lector;

//import com.google.gson.Gson;

//import com.google.gson.JsonParser;
// import org.json.simple.JSONArray;
// import org.json.simple.JSONObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

public class LectorCiudad {

  final Gson gson = new Gson();

  InterpretePistaCiudad interprete = new InterpretePistaCiudad();

  public ArrayList<Ciudad> leerCiudades() {

    JSONObject obj = new JSONObject();

    JSONParser parser = new JSONParser();

    File doc = new File("/src/main/java/edu/fiuba/algo3/recursos/ciudades.json");
    BufferedReader obj = new BufferedReader(new FileReader(doc));

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

    Object ob = new JSONParser().parse(new FileReader("JSONFile.json"));

    return null;
  }

  private Ciudad interpretarCiudad(String ciudad) {
    // return (Ciudad ciudad = new Ciudad(ciudad.nombre,
    // interprete.interpretar(listaPistas) ));
  }

}
