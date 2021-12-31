package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.EstadoVisitasCiudad;
import edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones.IEstrategiaAcciones;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.List;
import java.util.Random;

public class CiudadVisitada implements ICiudadVisitada {
    private final int cantidadEdificios = 3;
    private final EstadoVisitasCiudad visitas = new EstadoVisitasCiudad();
    private final List<Edificio> edificios;
    private final Policia policia;

    public CiudadVisitada(Ciudad estaCiudad, Policia policia, ISospechoso sospechoso,
                          IDestino ciudadSiguiente, IEstrategiaAcciones estrategiaAcciones, Random random)
    {
        this.edificios = estaCiudad.edificiosAlAzar(cantidadEdificios, random);
        this.policia = policia;
        List<IAccionador> accionadores = estrategiaAcciones.getAccionadores(cantidadEdificios, random);

        for(int i = 0; i<edificios.size(); i++) {
            Edificio edificio = edificios.get(i);
            IAccionador accionador = accionadores.get(i);
            edificio.visitadoPorLadron(sospechoso, ciudadSiguiente);
            edificio.setAccionador(accionador);
        }
    }

    @Override
    public List<Edificio> obtenerEdificios() {
        return edificios;
    }

    @Override
    public String visitar(Edificio edificio) throws AccionException, CalendarioException {
        if (!edificios.contains(edificio)) {
            return "¡Epa! No tenés permiso para entrar a este edificio.";
        }
        int demora = 0;
        try {
            demora = visitas.demoraEdificio();
            visitas.siguiente();
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        policia.avanzarHoras(demora);
        return edificio.visitar(policia);
    }
}
