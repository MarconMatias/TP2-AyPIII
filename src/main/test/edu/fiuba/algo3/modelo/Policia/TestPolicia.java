package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPolicia {

    @Test
    public void policiaNovatoViaja1800KmsYTarda2Horas() throws CalendarioException {

        Policia policia = new Policia("Agus",0, new Calendario());
        Assert.assertTrue(policia.viajar(1800) == 2);

    }

    @Test
    public void noSePuedeSetearUnaOrdenDeArrestoNulaYDevuelveNull(){

        Policia policia = new Policia("Agus",0,new Calendario());
    }

    @Test
    public void noSePuedeIniciarMisionConUnCalendarioNull(){

        Policia policia = new Policia("Agus",0, new Calendario());
    }

    @Test
    public void noSePuedeViajarDistanciasMenoresOIgualesA0YDevuelve0ElMensajeViajarSinHacerNada(){
        Policia policia = new Policia("Agus",0,new Calendario());
        Assert.assertTrue(policia.viajar(0) == 0);
        Assert.assertTrue(policia.viajar(-1) == 0);
    }

    @Test
    public void noSePuedeFiltrarPistasDeUnaCollectionDeIPistaYDevuelveEsasPistasSinHacerNadaElMensaje(){
        Policia policia = new Policia("Agus",0,new Calendario());
        Assert.assertTrue(policia.filtrarPistas(null) == null);
    }

    @Test
    public void noSePuedeVisitarUnEdificioNull(){
        Policia policia = new Policia("Agus",0,new Calendario());
        Assert.assertTrue(policia.visitar(null) == null);
    }

    @Test
    public void policiaNoPuedeRealizarUnaAccion(){

        Policia policia = new Policia("Agus",0,new Calendario());
    }

    @Test
    public void agregarUnArrestoAUnPoliciaNovatoIncrementaEnUno(){

        Policia policia = new Policia("Agus",0,new Calendario());
        policia.agregarArresto();
        Assert.assertTrue(policia.getArrestos() == 1);
    }

    @Test
    public void elConstructorDePoliciaElevaUnaExcepcionAlPasarAlgunoDeLosParametrosInvalidos(){

        assertThrows(IllegalArgumentException.class, () -> new Policia(null, 0, new Calendario()));
        assertThrows(IllegalArgumentException.class, () -> new Policia("Agus", -1, new Calendario()));
        assertThrows(IllegalArgumentException.class, () -> new Policia("Agus", 0, null));
    }

    @Test
    public void noSePuedeSetearUnaOrdenDeArrestoNull(){

        Policia policia = new Policia("Agus", 0, new Calendario());
        assertThrows(Exception.class, () -> policia.setOrdenDeArresto(null));

    }
}
