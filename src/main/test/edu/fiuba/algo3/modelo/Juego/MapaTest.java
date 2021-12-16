package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapaTest {

    @Test
    public void irDeCiudadACiudadConMapaVacioFalla()
    {
        Mapa mapa = new Mapa(new HashMap<String, Ciudad>());
        Policia policia = new Policia("Matute",0);
        Calendario calendario = new Calendario();
        try
        {
            mapa.viajar(policia, mapa.getCiudadPorNombre("Eregion"), "Rivendel");
            Assert.fail("Debe lanzar una excepción.");
        } catch (RuntimeException ex) {
        }
    }

    @Test
    public void irDeCiudadExistenteADestinoExistentePasa()
    {
        Mapa mapa = new Mapa(new HashMap<String,Ciudad>());
        Policia policia = new Policia("Matute",0);
        Calendario calendario = new Calendario();
        mapa.agregarConexion("Atenas","Bangkok",7917);
        mapa.viajar(policia, mapa.getCiudadPorNombre("Atenas"), "Bangkok");
    }

    @Test
    public void irDeCiudadExistenteACiudadExistenteNoDestinoFalla()
    {
        Mapa mapa = new Mapa(new HashMap<String,Ciudad>());
        Policia policia = new Policia("Matute",0);
        Calendario calendario = new Calendario();
        mapa.agregarConexion("Atenas","Bangkok",7917);
        mapa.agregarConexion("Bagdád","Colombo",4681);
        try
        {
            mapa.viajar(policia, mapa.getCiudadPorNombre("Atenas"), "Colombo");
            Assert.fail("Debe lanzar una excepción.");
        } catch (RuntimeException ex) {
        }
    }

    @Test
    public void viajarDeBamakoAMoroniEntre3DestinosLleva6270Km()
    {
        Mapa mapa = new Mapa(new HashMap<String,Ciudad>());
        Policia policia = mock(Policia.class);
        Calendario calendario = new Calendario();
        mapa.agregarConexion("Bamako","Montreal",7113);
        mapa.agregarConexion("Bamako","Moroni",6270);
        mapa.agregarConexion("Bamako","Tokyo",13657);

        mapa.viajar(policia, mapa.getCiudadPorNombre("Bamako"), "Moroni");
        verify(policia).viajar(6270);
    }

    @Test
    public void obtenerOrigenesConMapaVacioEstaVacio()
    {
        Mapa mapa = new Mapa(new HashMap<String,Ciudad>());
        assertEquals(0, mapa.getOrigenes().size());
    }

    @Test
    public void getOrigenesConMapa3OrigenesDevuelve3MismosOrigenes()
    {
        Mapa mapa = new Mapa(new HashMap<String,Ciudad>());
        mapa.agregarConexion("Bamako","Montreal",7113);
        mapa.agregarConexion("Bamako","Moroni",6270);
        mapa.agregarConexion("Bamako","Tokyo",13657);
        mapa.agregarConexion("Atenas","Bangkok",7917);
        mapa.agregarConexion("Moroni","Bamako",6270);
        List<String> origenes = mapa.getOrigenes();
        assertEquals(3, origenes.size());
        assertEquals("Atenas",origenes.get(0));
        assertEquals("Bamako",origenes.get(1));
        assertEquals("Moroni",origenes.get(2));
    }
}
