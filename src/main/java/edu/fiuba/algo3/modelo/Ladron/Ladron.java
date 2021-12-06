package edu.fiuba.algo3.modelo.Ladron;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Ladron implements ISospechoso {

  private final String nombre;
  private final String sexo;
  private final String deporte;
  private final String cabello;
  private final String distincion;
  private final String vehiculo;

  public Ladron(String nombre, String sexo, String deporte, String cabello, String distincion, String vehiculo) {

    this.nombre = nombre;
    this.sexo = sexo;
    this.deporte = deporte;
    this.cabello = cabello;
    this.distincion = distincion;
    this.vehiculo = vehiculo;

  }

  public IPista pistaAlAzar(Policia policia) {
    return null;
  }

  public boolean meLlamo(String string) {

    return string.equals(nombre);
  }

  public String mostrarDistincion() {

    System.out.println("Veo a un sujeto con un " + this.distincion + " dentro del edificio. ");
    return this.distincion;
  }

  @Override
  public String testimonioAlAzar(Policia policia, Ciudad destino, IFiltroCiudad filtroCiudad) {
    return destino.pistaAlAzar(policia,filtroCiudad) + mostrarDistincion();
  }

    public String getNombre() {
      return this.nombre;
    }
}
