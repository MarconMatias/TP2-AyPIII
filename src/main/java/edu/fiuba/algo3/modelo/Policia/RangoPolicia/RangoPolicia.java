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

<<<<<<< HEAD
    public void actualizarArrestos(){

        actualizarArrestos(this.arrestos + 1);
    }

    public void actualizarArrestos(int arrestos) {
        this.arrestos = arrestos;
=======
    public void actualizarArrestos(int cantidadDeArrestos) {
        this.arrestos = cantidadDeArrestos;
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
        this.comportamientoRango = this.comportamientoRango.siguienteComportamientoConArrestos(this.arrestos);
    }
}
