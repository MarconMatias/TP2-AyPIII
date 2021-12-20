package edu.fiuba.algo3.modelo.Juego;

import java.io.IOException;
import java.util.*;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Juego {

  ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
  ArrayList<Item> items = new ArrayList<Item>();
  Map<String, Ciudad> ciudades = new HashMap<String, Ciudad>();
  ArrayList<Policia> agentes = new ArrayList<Policia>();
  Mapa mapa;

  DatosJuego datos = new DatosJuego();
  private ObservableList<Policia> agentesObservable;

  public Juego() {
    ladrones = datos.leerLadrones();
    items = datos.leerItems();
    ciudades = datos.leerCiudades();
    agentes = datos.leerPolicias();
    agentesObservable = FXCollections.observableList(agentes);
    mapa = datos.leerMapa(ciudades);
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
}
