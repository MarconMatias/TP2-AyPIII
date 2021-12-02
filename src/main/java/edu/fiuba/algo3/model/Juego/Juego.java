package edu.fiuba.algo3.model.Juego;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.fiuba.algo3.model.Ladron.Ladron;

public class Juego {

  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();

  public Juego() throws IOException {

    leerLadrones();
    leerPistas();
    armarMapa();
    cargarAgentes(); // datos guardados de partidas
  }

  public void leerLadrones() throws IOException {
    // foreach row
    // ArrayList<String> caracteristicas = row.split(,);
    // ladron new (caracteristicas)
    BufferedReader lector = new BufferedReader(new FileReader("src/main/java/edu/fiuba/algo3/model/Ladron/DatosLadron/dossiers.csv"));
    try {
      String row;
      while ((row = lector.readLine()) != null) {
        String[] data = row.split(",");
        Ladron nuevoLadron = new Ladron(data[0], data[1], data[2], data[3], data[4], data[5]);
        ladrones.add(nuevoLadron);
      }
    } catch (IOException e) {
      lector.close();
    }
    lector.close();
    return;

  }

  private void leerPistas() {
    // implementar
  }

  private void armarMapa() {
  }

  private void cargarAgentes() {
    // implementar
  }

  public boolean existeElLadron(String string) {

    boolean resultado = false;

    for (Ladron l : ladrones) {
      if (l.meLlamo(string))
        resultado = true;
    }

    return resultado;
  }
}
