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

  public String mostrarDistincion() {
    String distincion = getDetalle("distincion","");
    System.out.println("Veo a un sujeto con un " + distincion + " dentro del edificio. ");
    return distincion;
  }

  @Override
  public String testimonioAlAzar(Policia policia, IDestino destino, IFiltroCiudad filtroCiudad) {
    return destino.pistaAlAzar(policia,filtroCiudad) + mostrarDistincion();
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
}
