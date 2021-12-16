package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RangoPolicia {

    private IComportamientoRango comportamientoRango;
    private NivelPista nivelPista;
    private Integer arrestos = 0;

    public RangoPolicia(){
        this.comportamientoRango = new ComoNovato();
    }

    public RangoPolicia(int cantidadDeArrestos) {
        this();
        this.actualizarArrestos(cantidadDeArrestos);
    }

    public ArrayList<IPista> filtrarPistas(Collection<IPista> pistas){

        return (ArrayList<IPista>) nivelPista.filtrarPistas(pistas);
    }

    public void actualizarArrestos(int cantidadDeArrestos) {
        this.arrestos = cantidadDeArrestos;
        this.comportamientoRango = this.comportamientoRango.siguienteComportamientoConArrestos(this.arrestos);
    }

    public int devolverTiempoDeViaje(int distancia) {

        return comportamientoRango.estimarTiempoDeViajePara( distancia );
    }
}
