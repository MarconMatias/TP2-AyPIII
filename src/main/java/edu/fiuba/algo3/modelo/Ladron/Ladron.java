package edu.fiuba.algo3.modelo.Ladron;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.HashMap;
import java.util.Map;

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


  public IPista pistaAlAzar(Policia policia) {
    return null;
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
  public String testimonioAlAzar(Policia policia, Ciudad destino, IFiltroCiudad filtroCiudad) {
    return destino.pistaAlAzar(policia,filtroCiudad) + mostrarDistincion();
  }

    public String getNombre() {
      return this.nombre;
    }
}
