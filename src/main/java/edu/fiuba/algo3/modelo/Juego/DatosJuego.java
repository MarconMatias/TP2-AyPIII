package edu.fiuba.algo3.modelo.Juego;

import java.util.ArrayList;
import java.util.Map;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Lector.LectorCiudad;
import edu.fiuba.algo3.modelo.Lector.LectorItem;
import edu.fiuba.algo3.modelo.Lector.LectorLadron;
import edu.fiuba.algo3.modelo.Lector.LectorPolicia;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class DatosJuego {

  LectorLadron lectorLadron = new LectorLadron();
  LectorItem lectorItem = new LectorItem();
  LectorCiudad lectorCiudad = new LectorCiudad();
  LectorPolicia lectorPolicia = new LectorPolicia();

  public DatosJuego() {

  }

  public ArrayList<Ladron> leerLadrones() {
    return lectorLadron.leerLadrones();
  }

  public ArrayList<Item> leerItems() {
    return lectorItem.leerItems();
  }

  public Map<String, Ciudad> leerCiudades() {
    return lectorCiudad.leerCiudades();
  }

  public ArrayList<Policia> leerPolicias() {
    return lectorPolicia.leerPolicias();
  }
}
