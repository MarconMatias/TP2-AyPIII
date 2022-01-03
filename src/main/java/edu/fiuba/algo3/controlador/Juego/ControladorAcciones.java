package edu.fiuba.algo3.controlador.Juego;

import edu.fiuba.algo3.controlador.ControlStage;
import edu.fiuba.algo3.modelo.Calendario.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;

public class ControladorAcciones implements IObservadorAcciones {
    private final Mision mision;
    private final ControlStage controlStage;
    private final Juego juego;

    public ControladorAcciones(Juego juego, Mision mision, ControlStage controlStage) {
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    @Override
    public void accionRealizada(IAccion accion) {
        String nombre = accion.getNombreAccion();
        //System.out.println("Acción: "+nombre);
        if(mision.fueFinalizada()) {
            return;
        }
        controlStage.mostrarAccion(mision, accion);
    }
}
