package edu.fiuba.algo3.controlador.Orden;

import edu.fiuba.algo3.ControlStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;

public class ExpedienteControlador {

  private final Juego juego;
  private final Mision mision;
  private final ControlStage controlStage;

  public ExpedienteControlador(Juego juego, Mision mision, ControlStage controlStage) {
    this.juego = juego;
    this.mision = mision;
    this.controlStage = controlStage;
  }

}
