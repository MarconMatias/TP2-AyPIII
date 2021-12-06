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

  private Ciudad interpretarCiudad(String ciudad) {
    // return (Ciudad ciudad = new Ciudad(ciudad.nombre,
    // interprete.interpretar(listaPistas) ));
    return null;
  }

}
