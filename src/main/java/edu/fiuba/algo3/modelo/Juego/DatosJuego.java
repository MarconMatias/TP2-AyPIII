package edu.fiuba.algo3.modelo.Juego;

import java.util.ArrayList;
import java.util.Map;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Ciudad.Mapa;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class DatosJuego {

  LectorLadron lectorLadron = new LectorLadron();
  LectorItem lectorItem = new LectorItem();
  LectorCiudad lectorCiudad = new LectorCiudad();
  Map<String,Ciudad> ciudades = null;
  LectorPolicia lectorPolicia = new LectorPolicia();
  LectorMapa lectorMapa = new LectorMapa();

  public DatosJuego() {

  }

  public ArrayList<Ladron> leerLadrones() {
    return lectorLadron.leerLadrones();
  }

  public ArrayList<Item> leerItems() {
    return lectorItem.leerItems();
  }

  public Map<String, Ciudad> leerCiudades() {
    if(null != ciudades) {
      return ciudades;
    }
    return ciudades = lectorCiudad.leerCiudades();
  }

  public Mapa leerMapa(Map<String, Ciudad> ciudades) {
    return lectorMapa.leerMapa(new Mapa(leerCiudades()));
  }
  public ArrayList<Policia> leerPolicias() {
    return lectorPolicia.leerPolicias();
  }
}
