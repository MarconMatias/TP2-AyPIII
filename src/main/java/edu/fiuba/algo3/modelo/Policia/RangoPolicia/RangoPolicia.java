package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;

import java.util.ArrayList;
import java.util.Collection;

public class RangoPolicia {

    private IComportamientoRango comportamientoRango;
    private Integer arrestos = 0;

    public RangoPolicia(int cantidadDeArrestos) {
        arrestos = cantidadDeArrestos;
        this.comportamientoRango = new ComoNovato();
        actualizarArrestos(cantidadDeArrestos);
    }

    public RangoPolicia() {
        this(0);
    }

    public ArrayList<IPista> filtrarPistas(Collection<IPista> pistas) {
        return new ArrayList<IPista>(comportamientoRango.filtrarPistas(pistas));
    }

    private void actualizarArrestos(int cantidadDeArrestos) {
        this.arrestos = cantidadDeArrestos;
        this.comportamientoRango = this.comportamientoRango.siguienteComportamientoConArrestos(this.arrestos);
    }

    public int devolverTiempoDeViaje(int distancia) {

        return comportamientoRango.estimarTiempoDeViajePara( distancia );
    }

    public void agregarArresto(int arrestos) {
        this.arrestos += arrestos;
        actualizarArrestos(arrestos);
    }

    public String getNombreRango() {
        return comportamientoRango.getNombreRango();
    }

    public String getInsignia() {
        return comportamientoRango.getInsignia();
    }
}
