package edu.fiuba.algo3.modelo.Policia.RangoPolicia;

import edu.fiuba.algo3.modelo.Pista.IPista;

import java.util.Collection;

public interface IComportamientoRango {


    IComportamientoRango ascender(Integer arrestos);

    IComportamientoRango siguienteComportamientoConArrestos(Integer arrestos);

    int estimarTiempoDeViajePara(int distancia);

    Collection<IPista> filtrarPistas(Collection<IPista> pistas);
}
