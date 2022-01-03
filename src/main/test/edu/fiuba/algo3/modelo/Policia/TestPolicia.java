package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPolicia {

    @Test
    public void policiaNovatoViaja1800KmsYTarda2Horas() throws AccionException, CalendarioException, PoliciaException {

        Policia policia = new Policia("Agus",0, new Calendario());
        Assert.assertTrue(policia.viajar(1800) == 2);
    }

    @Test
    public void policiaNoPuedeViajarDistanciasNegativasElevaExcepcion(){

        Policia policia = new Policia("Agustin",0,new Calendario());
        assertThrows(IllegalArgumentException.class, () -> policia.viajar(-10));
    }
    @Test
    public void noSePuedeSetearUnaOrdenDeArrestoNulaYElevaUnaExcepcion(){

        Policia policia = new Policia("Agus",0,new Calendario());
        assertThrows(PoliciaException.class ,() -> policia.setOrdenDeArresto(null));
    }

    @Test
    public void noSePuedeIniciarMisionConUnCalendarioNull(){

        Policia policia = new Policia("Agus",0, new Calendario());
        assertThrows(IllegalArgumentException.class, () -> policia.iniciarMision(null));
    }

    @Test
    public void noSePuedeViajarDistanciasMenoresOIgualesA0YDevuelve0ElMensajeViajarSinHacerNada() throws AccionException, CalendarioException, PoliciaException {
        Policia policia = new Policia("Agus",0,new Calendario());
        Assert.assertTrue(policia.viajar(0) == 0);
        assertThrows(IllegalArgumentException.class, () -> policia.viajar(-1));
    }

    @Test
    public void noSePuedeVisitarUnEdificioNull() throws AccionException, CalendarioException {
        Policia policia = new Policia("Agus",0,new Calendario());
        assertThrows(IllegalArgumentException.class, () -> policia.visitar(null));
    }

    @Test
    public void policiaNoPuedeRealizarUnaAccionNull(){

        Policia policia = new Policia("Agus",0,new Calendario());
        assertThrows(NullPointerException.class, () -> policia.realizarAccion(null));
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
    public void noSePuedeSetearUnaOrdenDeArrestoNullYElevaExcepcion(){

        Policia policia = new Policia("Agus", 0, new Calendario());
        assertThrows(Exception.class, () -> policia.setOrdenDeArresto(null));
    }

    @Test
    public void noSePuedeFiltrarUnArrayDePistasNullYElevaExcepcion(){

        Policia policia = new Policia("Agus", 0, new Calendario());
        assertThrows(IllegalArgumentException.class, () -> policia.filtrarPistas(null));
    }

    @Test
    public void noPuedeAvanzarHorasConUnCalendarioNuloAlSerAcuchilladoYElevaExcepcion(){

        Policia policia = new Policia("Agus", 0, new Calendario());
        assertThrows(NullPointerException.class, () -> policia.avanzarHorasCuchillada(null));
    }

    @Test
    public void noSePuedeEnfrentarUnLadronNulo(){

        Policia policia = new Policia("Agus", 0, new Calendario());
        assertThrows(IllegalArgumentException.class, () -> policia.enfrentar(null));
    }

    @Test
    public void recibirUnaAcuchilladaCambiaElEstadoAAcuchillado(){

        Calendario calendario = new Calendario();
        Policia policia = new Policia("Agus", 0, calendario);
        policia.recibirCuchillada();
        Assert.assertTrue(policia.fuiAcuchillado() == true );
    }
}
