package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.componentes.Imagen.IconoVolver;
import edu.fiuba.algo3.componentes.Imagen.ImagenSeleccionable;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.controlador.Orden.ExpedienteControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

public class Expediente extends Documentos {
  private final double anguloRotacion = -9;
  private final Juego juego;
  private final Mision mision;
  private final ExpedienteControlador controlador;
  private final ImagenSeleccionable orden;

  public Expediente(Juego juego, Mision mision, Ladron ladron, ExpedienteControlador controlador) {
    super(juego, mision, ladron, controlador);

    this.juego = juego;
    this.mision = mision;
    this.controlador = controlador;

    tituloHoja.setText(ladron.getNombre());
    detallesPane.setTitulo("Expediente:");

    orden = new IconoVolver(640);
    agregar(orden, 0.75, 0.9);

    setTarjetasVisible(true);
    setCalendario(mision.getCalendario());
    setRelojVisible(true);
    setRadio(juego.getRadio());
    iniciarControlador(controlador);
  }

  @Override
  protected void iniciarControlador(PantallaControlador controlador) {
    super.iniciarControlador(controlador);
    if(null == controlador) {
      return;
    }
    if(null != orden) {
      orden.setOnMouseClicked(controlador::ordenClicked);
      orden.setOnKeyPressed(controlador::ordenKeyPressed);
    }
  }

  @Override
  public String getTitulo() {
    return "Elija un sospechoso para ver sus detalles";
  }
}
