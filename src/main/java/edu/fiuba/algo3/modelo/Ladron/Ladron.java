package edu.fiuba.algo3.modelo.Ladron;

import edu.fiuba.algo3.modelo.Ciudad.IDestino;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.*;

public class Ladron implements ISospechoso {
  private final String nombre;
  private final Map<String,String> detalles;
  public Ladron(String nombre, Map<String,String> detalles) {
    this.nombre = nombre;
    this.detalles = detalles;
  }

  private static Map<String,String> crearDetalles(String sexo, String deporte, String cabello, String distincion, String vehiculo)
  {
    Map<String,String> map = new HashMap<String,String>();
    map.put("sexo", sexo);
    map.put("deporte", deporte);
    map.put("cabello", cabello);
    map.put("distincion", distincion);
    map.put("vehiculo", vehiculo);
    return map;
  }
  public Ladron(String nombre, String sexo, String deporte, String cabello, String distincion, String vehiculo) {
    this(nombre, crearDetalles(sexo,deporte,cabello,distincion,vehiculo));
  }

  public boolean meLlamo(String string) {

    return string.equals(nombre);
  }

  public String getDetalle(String tipo, String porDefecto)
  {
    return this.detalles.getOrDefault(tipo,porDefecto);
  }

  public String detalleAlAzar(Random random) {
    final String noHayDetalles = "No puedo aportar ningún detalle sobre esa persona.";
    if(0 == detalles.size()) {
      System.err.println(this + " no tiene detalles.");
      return noHayDetalles;
    }
    int posicionAlAzar = random.nextInt(detalles.size());
    String tipo = detalles.keySet().stream().limit(posicionAlAzar)
            .reduce((s1,s2)->s2).orElse(null);
    if(null == tipo) {
      System.err.println(this + " no encuentra tipo.");
      return noHayDetalles;
    }
    String valor = detalles.get(tipo);
    String pistaDetalle = "Su " + tipo + " es " + valor + ".";
    System.out.println(pistaDetalle);
    return pistaDetalle;
  }

  @Override
  public String testimonioAlAzar(Policia policia, IDestino destino, IFiltroCiudad filtroCiudad) {
    return destino.pistaAlAzar(policia,filtroCiudad) + detalleAlAzar(new Random());
  }

    public String getNombre() {
      return this.nombre;
    }

  public void agregarSiCoincideDetalle(Map<String, String> detallesBuscados, ArrayList<Ladron> sospechososFiltrados) {

    for (String tipo : detallesBuscados.keySet()) {
      String valorBuscado = detallesBuscados.get(tipo).trim();
      String valorDeEste = this.detalles.get(tipo.trim());
      if(!valorBuscado.equals(valorDeEste)) {
        return;
      }
    }
    sospechososFiltrados.add(this);
  }

  public void agregarDetallesAMap(Map<String, Set<String>> map) {
    for(String tipo : detalles.keySet()) {
      tipo = tipo.trim();
      String valor = detalles.get(tipo).trim();
      if(!map.containsKey(tipo)) {
        map.put(tipo, new HashSet<String>(Set.of(valor)));
      } else {
        map.get(tipo).add(valor);
      }
    }
  }

  @Override
  public String toString() {
    if((null==nombre)||(nombre.trim().equals(""))) {
      return Integer.toString(hashCode());
    }
    return nombre;
  }
}
