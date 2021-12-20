package edu.fiuba.algo3.modelo.Juego;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Juego {

  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
  ArrayList<Item> items = new ArrayList<Item>();
  Map<String, Ciudad> ciudades = new HashMap<String, Ciudad>();
  ArrayList<Policia> agentes = new ArrayList<Policia>();

  DatosJuego datos = new DatosJuego();

  public Juego() throws IOException {

    ladrones = datos.leerLadrones();
    items = datos.leerItems();
    ciudades = datos.leerCiudades();
    // armarMapa
    agentes = datos.leerPolicias();
  }

  public Ciudad darUnaCiudadRandom() {
    Random nuevoRandom = new Random();
    return ciudades.get(nuevoRandom.nextInt(this.ciudades.size()));
  }
}
