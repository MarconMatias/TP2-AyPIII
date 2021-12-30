package edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;

public class NoVisitado implements IEstadoVisitado {

    private final IAccion accion;

    public NoVisitado(IAccion accion)
    {
        this.accion = accion;
    }

    @Override
    public void visitar(Edificio edificio, Policia policia) throws AccionException, CalendarioException {

        if(edificio == null || policia == null)
            throw new IllegalArgumentException("Error. El edificio o el policia pasado por el argumento es invalido.");
        try{
            policia.realizarAccion(accion);
        }
        catch(AccionException | CalendarioException e){
            //Aca deberia aparecer un cuadro de error
        }
    }

    @Override
    public IEstadoVisitado siguiente() {
        return new Visitado();
    }
}
