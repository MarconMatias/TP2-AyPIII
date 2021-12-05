package edu.fiuba.algo3.modelo.Juego;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;

import edu.fiuba.algo3.modelo.Lector.*;

public class Juego {

  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
  ArrayList<PistaCiudad> pistasPaises = new ArrayList<PistaCiudad>();
  ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
  ArrayList<Policia> agentes = new ArrayList<Policia>();
  ArrayList<Item> items = new ArrayList<Item>();

  public Juego() throws IOException {

    leerLadrones();
    leerItems();
    leerPistas();
    leerCiudades();
    armarMapa();
    leerAgentes(); // datos guardados de partidas
  }

  public void leerItems() throws IOException {

    BufferedReader lector = new BufferedReader(new FileReader("src/main/java/edu/fiuba/algo3/model/Item/items.csv"));
    try {
      String row;
      while ((row = lector.readLine()) != null) {
        String[] data = row.split(";");
        Item nuevoItem = new Item(data[0], data[1]);
        items.add(nuevoItem);
      }
    } catch (IOException e) {
      lector.close();
    }
    lector.close();

  }

  public void leerPistas() {

  }

  public void leerLadrones() throws IOException {
    // foreach row
    // ArrayList<String> caracteristicas = row.split(,);
    // ladron new (caracteristicas)
    BufferedReader lector = new BufferedReader(
        new FileReader("src/main/java/edu/fiuba/algo3/model/Ladron/DatosLadron/dossiers.csv"));
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

    LectorCiudad lector = new LectorCiudad();
    ciudades = lector.leerCiudades();

  }

  private void armarMapa() {
  }

  public void leerAgentes() throws IOException {

    BufferedReader lector = new BufferedReader(
        new FileReader("src/main/java/edu/fiuba/algo3/model/Policia/agentes.csv"));
    try {
      String row;
      while ((row = lector.readLine()) != null) {
        String[] data = row.split(";");
        Policia nuevoAgente = new Policia(new RangoPolicia(), data[0]);
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

    for (Ciudad c : ciudades) {

      if (c.esLaCiudad(ciudad))
        resultado = true;
    }

    return resultado;
  }

  public boolean existeElAgente(String nombreAgente) {

    boolean resultado = false;

    for (Policia p : agentes) {

      if (p.soyElAgente(nombreAgente))
        resultado = true;
    }

    return resultado;
  }

  public boolean existeElItem(String nombreItem) {

    boolean resultado = false;

    for (Item i : items) {

      if (i.estaElItem(nombreItem))
        resultado = true;
    }

    return resultado;
  }

  public Ciudad darUnaCiudadRandom() {

    Random nuevoRandom = new Random();
    return ciudades.get(nuevoRandom.nextInt(this.ciudades.size()));
  }
}
