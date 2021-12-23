package edu.fiuba.algo3.controlador.Expediente;

import edu.fiuba.algo3.ControladorStage;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;

public class ExpedienteControlador {

  private final Juego juego;
  private final Mision mision;
  private final ControladorStage controladorStage;

  public ExpedienteControlador(Juego juego, Mision mision, ControladorStage controladorStage) {
    this.juego = juego;
    this.mision = mision;
    this.controladorStage = controladorStage;
  }

}
