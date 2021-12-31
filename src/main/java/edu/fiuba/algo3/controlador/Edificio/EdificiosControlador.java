package edu.fiuba.algo3.controlador.Edificio;

import edu.fiuba.algo3.controlador.ControlStage;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Edificio.DestinoEdificio;

public class EdificiosControlador extends PantallaControlador {
    private final Juego juego;
    private final Mision mision;
    private final ControlStage controlStage;

    public EdificiosControlador(Juego juego, Mision mision, ControlStage controlStage) {
        super(juego, mision, controlStage);
        this.juego = juego;
        this.mision = mision;
        this.controlStage = controlStage;
    }

    public void destinoElegido(DestinoEdificio destino) {
        Edificio edificio = destino.getEdificio();
        System.out.println("Visitando edificio "+edificio.getNombre());
        String testimonio = mision.visitarEdificio(edificio);
        String testigo = mision.getTestigo(edificio);
        System.out.println(testigo + " dice: "+testimonio);
        if(mision.fueFinalizada() || controlStage.abrirTestigo(testigo,testimonio))
        {
            liberar();
        }
    }

}
