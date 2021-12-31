package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaFacil;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RangoPolicia {

    private IComportamientoRango comportamientoRango;
    private Integer arrestos = 0;

    public RangoPolicia(int cantidadDeArrestos) {
        arrestos = cantidadDeArrestos;
        this.comportamientoRango = new ComoNovato();
        this.actualizarArrestos(cantidadDeArrestos);
    }

    public RangoPolicia() {
        this(0);
    }

    public ArrayList<IPista> filtrarPistas(Collection<IPista> pistas){

        return new ArrayList<IPista>(comportamientoRango.filtrarPistas(pistas));
    }

    public void actualizarArrestos(int cantidadDeArrestos) {
        this.arrestos = cantidadDeArrestos;
        this.comportamientoRango = this.comportamientoRango.siguienteComportamientoConArrestos(this.arrestos);
    }

    public int devolverTiempoDeViaje(int distancia) {

        return comportamientoRango.estimarTiempoDeViajePara( distancia );
    }

    public void agregarArresto(int arrestos) {
        this.arrestos = arrestos;
        actualizarArrestos(arrestos);
    }

    public String getNombreRango() {
        return comportamientoRango.getNombreRango();
    }

    public String getInsignia() {
        return comportamientoRango.getInsignia();
    }
}
