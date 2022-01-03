package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Ciudad.Mapa;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.Radio.Radio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Juego {

  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
  ArrayList<Item> items = new ArrayList<Item>();
  Map<String, Ciudad> ciudades = new HashMap<String, Ciudad>();
  ArrayList<Policia> agentes = new ArrayList<Policia>();
  Mapa mapa;
  Radio radio = new Radio();

  DatosJuego datos = new DatosJuego();
  private ObservableList<Policia> agentesObservable;

  public Juego() {
    try {
      ladrones = datos.leerLadrones();
      items = datos.leerItems();
      ciudades = datos.leerCiudades();
      agentes = datos.leerPolicias();
      agentesObservable = FXCollections.observableList(agentes);
      mapa = datos.leerMapa(ciudades);
    } catch(Exception ex) {
      throw new RuntimeException("No pudo iniciarse el juego:\n"+ex);
    }
  }

  public ObservableList<Policia> getPolicias() {
    return agentesObservable;
  }

  public Mision nuevaMision(Policia policia) {
    return new Mision(policia, items, ladrones, mapa);
  }

  public Policia nuevoPolicia(String nombre) {
    Policia nuevo = new Policia(nombre);
    agentesObservable.add(nuevo);
    return nuevo;
  }

  public Radio getRadio() {
    return radio;
  }
}
