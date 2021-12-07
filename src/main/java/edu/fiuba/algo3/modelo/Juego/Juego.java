package edu.fiuba.algo3.modelo.Juego;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
  ArrayList<Item> items = new ArrayList<Item>();
  Map<String,Ciudad> ciudades = new HashMap<String,Ciudad>();
  ArrayList<Policia> agentes = new ArrayList<Policia>();

  LectorCiudad lectorCiudad = new LectorCiudad();
  LectorItem lectorItem = new LectorItem();
  LectorLadron lectorLadron = new LectorLadron();

  public Juego() throws IOException {

    leerLadrones();
    leerItems();
    leerCiudades();
    armarMapa();
    leerAgentes(); // datos guardados de partidas
  }


  private void leerLadrones() throws IOException {

    ladrones = lectorLadron.leerLadrones();
  }

  private void leerItems() throws IOException {
    items = lectorItem.leerItems();
  }

  private void leerCiudades() throws IOException {
    ciudades = lectorCiudad.leerCiudades();
  }

  private void armarMapa() {
  }

  private void leerAgentes() throws IOException {
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

  public Ciudad darUnaCiudadRandom() {
    Random nuevoRandom = new Random();
    return ciudades.get(nuevoRandom.nextInt(this.ciudades.size()));
  }
}
