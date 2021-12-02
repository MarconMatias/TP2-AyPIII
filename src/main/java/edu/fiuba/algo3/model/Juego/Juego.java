package edu.fiuba.algo3.model.Juego;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.fiuba.algo3.model.Ciudad.Ciudad;
import edu.fiuba.algo3.model.Ladron.Ladron;
import edu.fiuba.algo3.model.Pista.PistaCiudad;
import edu.fiuba.algo3.model.Policia.Policia;
import edu.fiuba.algo3.model.Policia.RangoPolicia.RangoPolicia;

public class Juego {

  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
  ArrayList<PistaCiudad> pistasPaises = new ArrayList<PistaCiudad>();
  ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
  ArrayList<Policia> agentes = new ArrayList<Policia>();

  public Juego() throws IOException {

    leerLadrones();
    leerPistas();
    leerCiudades();
    armarMapa();
    cargarAgentes(); // datos guardados de partidas
  }

  public void leerPistas() {

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

  }

  public void leerCiudades() throws IOException {

    BufferedReader lector = new BufferedReader(new FileReader("src/main/java/edu/fiuba/algo3/model/Ciudad/ciudades.csv"));
    try {
      String row;
      while ((row = lector.readLine()) != null) {
        String[] data = row.split(";");
        Ciudad nuevaCiduad = new Ciudad(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10], data[11], data[12]);
        ciudades.add(nuevaCiduad);
      }
    } catch (IOException e) {
      lector.close();
    }
    lector.close();

  }

  private void armarMapa() {
  }

  public void cargarAgentes() throws IOException {

    BufferedReader lector = new BufferedReader(new FileReader("src/main/java/edu/fiuba/algo3/model/Policia/agentes.csv"));
    try {
      String row;
      while ((row = lector.readLine()) != null) {
        String[] data = row.split(";");
        Policia nuevoAgente = new Policia((new RangoPolicia(data[1]) ), data[0]);
        agentes.add(nuevoAgente);
      }
    } catch (IOException e) {
      lector.close();
    }
    lector.close();

  }

  public boolean existeElLadron(String string) {

    boolean resultado = false;

    for (Ladron l : ladrones) {
      if (l.meLlamo(string))
        resultado = true;
    }

    return resultado;
  }

  public boolean existeLaCiudad(String ciudad) {

    boolean resultado = false;

    for (Ciudad c : ciudades){

      if (c.esLaCiudad(ciudad))
        resultado = true;
    }

    return resultado;
  }

  public boolean existeElAgente(String nombreAgente) {

    boolean resultado = false;

    for (Policia p : agentes){

      if (p.soyElAgente(nombreAgente))
        resultado = true;
    }

    return resultado;
  }
}
