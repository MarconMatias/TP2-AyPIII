package edu.fiuba.algo3.model.Ladron;

import edu.fiuba.algo3.model.Pista.IPista;
import edu.fiuba.algo3.model.Policia.Policia;

public class Ladron {

  private String nombre;
  private String genero;
  private String deporte;
  private String colorDeCabello;
  private String seña;
  private String vehiculo;

  public Ladron(String nombre, String genero, String deporte, String colorDeCabello, String seña, String vehiculo){

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
}
