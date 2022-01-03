package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Ciudad.Mapa;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.ArrayList;
import java.util.Map;

public class DatosJuego {

  LectorLadron lectorLadron = new LectorLadron();
  LectorItem lectorItem = new LectorItem();
  LectorCiudad lectorCiudad = new LectorCiudad();
  Map<String,Ciudad> ciudades = null;
  LectorPolicia lectorPolicia = new LectorPolicia();
  LectorMapa lectorMapa = new LectorMapa();

  public DatosJuego() {

  }

  public ArrayList<Ladron> leerLadrones() throws LectorException {
    return lectorLadron.leerLadrones();
  }

  public ArrayList<Item> leerItems() throws LectorException {
    return lectorItem.leerItems();
  }

  public Map<String, Ciudad> leerCiudades() throws LectorException {
    if(null != ciudades) {
      return ciudades;
    }
    return ciudades = lectorCiudad.leerCiudades();
  }

  public Mapa leerMapa(Map<String, Ciudad> ciudades) throws LectorException {
    return lectorMapa.leerMapa(new Mapa(leerCiudades()));
  }
  public ArrayList<Policia> leerPolicias() throws LectorException {
    return lectorPolicia.leerPolicias();
  }
}
