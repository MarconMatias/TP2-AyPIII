package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapaTest {
    @Test
    public void irDeCiudadACiudadConMapaVacioFalla()
    {
        Mapa mapa = new Mapa();
        Policia policia = new Policia(new RangoPolicia(), "Matute");
        Calendario calendario = new Calendario();
        try
        {
            mapa.viajar(policia, "Eregion", "Rivendel", calendario);
            Assert.fail("Debe lanzar una excepción.");
        } catch (RuntimeException ex) {
        }
    }

    @Test
    public void irDeCiudadExistenteADestinoExistentePasa()
    {
        Mapa mapa = new Mapa();
        Policia policia = new Policia(new RangoPolicia(), "Matute");
        Calendario calendario = new Calendario();
        mapa.agregarConexion("Atenas","Bangkok",7917);
        mapa.viajar(policia, "Atenas", "Bangkok", calendario);
    }

    @Test
    public void irDeCiudadExistenteACiudadExistenteNoDestinoFalla()
    {
        Mapa mapa = new Mapa();
        Policia policia = new Policia(new RangoPolicia(), "Matute");
        Calendario calendario = new Calendario();
        mapa.agregarConexion("Atenas","Bangkok",7917);
        mapa.agregarConexion("Bagdád","Colombo",4681);
        try
        {
            mapa.viajar(policia, "Atenas", "Colombo", calendario);
            Assert.fail("Debe lanzar una excepción.");
        } catch (RuntimeException ex) {
        }
    }

    @Test
    public void viajarDeBamakoAMoroniEntre3DestinosLleva6270Km()
    {
        Mapa mapa = new Mapa();
        Policia policia = mock(Policia.class);
        Calendario calendario = new Calendario();
        mapa.agregarConexion("Bamako","Montreal",7113);
        mapa.agregarConexion("Bamako","Moroni",6270);
        mapa.agregarConexion("Bamako","Tokyo",13657);

        mapa.viajar(policia, "Bamako", "Moroni", calendario);
        verify(policia).viajar(6270,calendario);
    }

    @Test
    public void obtenerOrigenesConMapaVacioEstaVacio()
    {
        Mapa mapa = new Mapa();
        assertEquals(0, mapa.getOrigenes().size());
    }
}
