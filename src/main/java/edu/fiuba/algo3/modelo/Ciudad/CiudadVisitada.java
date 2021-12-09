package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.EstadoVisitasCiudad;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.ArrayList;
import java.util.List;

public class CiudadVisitada implements IComportamientoCiudad {
    /*
    private final int cantidadEdificios = 3;

    private final Ciudad ciudad;
    private final Calendario cal;
    private final Policia policia;
    private final EstadoVisitasCiudad visitas = new EstadoVisitasCiudad();
    private final List<ITipoEdificio> edificios;
    private Ladron ladron = null;
    private Ciudad destino = null;

    public CiudadVisitada(Ciudad ciudad, Policia policia, Calendario cal)
    {
        this.ciudad = ciudad;
        this.policia = policia;
        this.cal = cal;

        //edificios = ciudad.edificiosAlAzar(3);
        throw new RuntimeException("Revisar");
    }

    public void visitadoPorLadron(Ladron ladron, Ciudad destino)
    {
        for(ITipoEdificio edificio : edificios) {
            edificio.visitadoPorLadron(ladron,destino);
        }
    }

    public void visitarEdificio(ITipoEdificio edificio)
    {
        int demora = visitas.demoraEdificio();
        visitas.siguiente();
        cal.avanzarHoras(demora);
        edificio.visitar(policia,cal);
    }
     */
}
