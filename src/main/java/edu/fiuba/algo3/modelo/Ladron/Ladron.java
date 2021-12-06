package edu.fiuba.algo3.modelo.Ladron;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Ladron implements ISospechoso {

  private String nombre;
  private String genero;
  private String deporte;
  private String colorDeCabello;
  private String seña;
  private String vehiculo;

  public Ladron(String nombre, String genero, String deporte, String colorDeCabello, String seña, String vehiculo) {

    this.nombre = nombre;
    this.genero = genero;
    this.deporte = deporte;
    this.colorDeCabello = colorDeCabello;
    this.seña = seña;
    this.vehiculo = vehiculo;

  }

  public IPista pistaAlAzar(Policia policia) {
    return null;
  }

  public boolean meLlamo(String string) {

    return string.equals(nombre);
  }

    public String mostrarSeña() {

      System.out.println("Veo a un sujeto con un " + this.seña + " dentro del edificio. ");
      return this.seña;
    }

  public String testimonioAlAzar(Policia policia, Ciudad destino, IFiltroCiudad filtroCiudad) {
    return destino.pistaAlAzar(policia,filtroCiudad) + mostrarSeña();
  }
}
