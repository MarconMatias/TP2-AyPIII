package edu.fiuba.algo3.modelo.Edificio.HacerUnaSolaVez;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class NoVisitado implements IEstadoVisitado {

    public NoVisitado(/** Accion **/)
    {
        // Guardar la acción
    }

    @Override
    public void visitar(ITipoEdificio edificio, Policia policia) {
        // Ejecutar la acción
    }

    @Override
    public IEstadoVisitado siguiente() {
        return new Visitado();
    }
}
