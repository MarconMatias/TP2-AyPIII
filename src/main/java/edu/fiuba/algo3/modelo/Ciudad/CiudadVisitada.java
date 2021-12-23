package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.EstadoVisitasCiudad;
import edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones.IEstrategiaAcciones;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.List;

public class CiudadVisitada implements ICiudadVisitada {
    private final int cantidadEdificios = 3;
    private final EstadoVisitasCiudad visitas = new EstadoVisitasCiudad();
    private final List<Edificio> edificios;
    private final Policia policia;

    public CiudadVisitada(Ciudad estaCiudad, Policia policia, ISospechoso sospechoso, IDestino ciudadSiguiente, IEstrategiaAcciones estrategiaAcciones)
    {
        this.edificios = estaCiudad.edificiosAlAzar(cantidadEdificios);
        this.policia = policia;
        List<IAccionador> accionadores = estrategiaAcciones.getAccionadores(cantidadEdificios);

        for(int i = 0; i<edificios.size(); i++) {
            Edificio edificio = edificios.get(i);
            IAccionador accionador = accionadores.get(i);
            edificio.visitadoPorLadron(sospechoso,ciudadSiguiente);
            edificio.setAccionador(accionador);
        }
    }

    @Override
    public List<Edificio> obtenerEdificios() {
        return edificios;
    }

    @Override
    public String visitar(Edificio edificio)
    {
        if(!edificios.contains(edificio)) {
            return "¡Epa! No tenés permiso para entrar a este edificio.";
        }
        int demora = visitas.demoraEdificio();
        visitas.siguiente();
        policia.avanzarHoras(demora);
        return edificio.visitar(policia);
    }
}
