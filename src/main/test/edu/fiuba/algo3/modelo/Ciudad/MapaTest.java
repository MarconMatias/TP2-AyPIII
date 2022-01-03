package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MapaTest {

    @Test
    public void irDeCiudadACiudadConMapaVacioFalla()
    {
        Mapa mapa = new Mapa(new HashMap<String, Ciudad>());
        Ciudad eregion = new Ciudad("Eregion", Collections.emptyList());
        Ciudad rivendel = new Ciudad("Rivendel", Collections.emptyList());
        Policia policia = new Policia("Matute",0);
        Calendario calendario = new Calendario();
        try
        {
            mapa.viajar(policia, eregion, rivendel);
            Assert.fail("Debe lanzar una excepción.");
        } catch (RuntimeException ex) {
        } catch (PoliciaException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void irDeCiudadExistenteADestinoExistentePasa() throws PoliciaException {
        Ciudad atenas = new Ciudad("Atenas", Collections.emptyList());
        Ciudad bangkok = new Ciudad("Bangkok", Collections.emptyList());
        Mapa mapa = new Mapa(List.of(atenas,bangkok));
        Policia policia = new Policia("Matute",0);
        Calendario calendario = new Calendario();
        mapa.agregarConexion(atenas,bangkok,7917);
        mapa.viajar(policia, atenas, bangkok);
    }

    @Test
    public void irDeCiudadExistenteACiudadExistenteNoDestinoFalla()
    {
        Ciudad atenas = new Ciudad("Atenas", Collections.emptyList());
        Ciudad bagdad = new Ciudad("Bagdad", Collections.emptyList());
        Ciudad bangkok = new Ciudad("Bangkok", Collections.emptyList());
        Ciudad colombo = new Ciudad("Colombo", Collections.emptyList());
        Mapa mapa = new Mapa(List.of(atenas,bagdad, bangkok, colombo));
        Policia policia = new Policia("Matute",0);
        Calendario calendario = new Calendario();
        mapa.agregarConexion(atenas,bangkok,7917);
        mapa.agregarConexion(bagdad,colombo,4681);
        try
        {
            mapa.viajar(policia, atenas, colombo);
            Assert.fail("Debe lanzar una excepción.");
        } catch (RuntimeException ex) {
        } catch (PoliciaException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void viajarDeBamakoAMoroniEntre3DestinosLleva6270Km() throws PoliciaException, CalendarioException {
        Ciudad bamako = new Ciudad("Bamako", Collections.emptyList());
        Ciudad montreal = new Ciudad("Montreal", Collections.emptyList());
        Ciudad moroni = new Ciudad("Moroni", Collections.emptyList());
        Ciudad tokyo = new Ciudad("Tokyo", Collections.emptyList());
        Mapa mapa = new Mapa(List.of(bamako, montreal, moroni, tokyo));
        Policia policia = mock(Policia.class);
        Calendario calendario = new Calendario();
        mapa.agregarConexion(bamako,montreal,7113);
        mapa.agregarConexion(bamako,moroni,6270);
        mapa.agregarConexion(bamako,tokyo,13657);

        mapa.viajar(policia, bamako, moroni);
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
        Ciudad atenas = new Ciudad("Atenas", Collections.emptyList());
        Ciudad bamako = new Ciudad("Bamako", Collections.emptyList());
        Ciudad bangkok = new Ciudad("Bangkok", Collections.emptyList());
        Ciudad montreal = new Ciudad("Montreal", Collections.emptyList());
        Ciudad moroni = new Ciudad("Moroni", Collections.emptyList());
        Ciudad tokyo = new Ciudad("Tokyo", Collections.emptyList());
        Mapa mapa = new Mapa(List.of(atenas,bamako,bangkok,montreal,moroni,tokyo));
        mapa.agregarConexion(bamako,montreal,7113);
        mapa.agregarConexion(bamako,moroni,6270);
        mapa.agregarConexion(bamako,tokyo,13657);
        mapa.agregarConexion(atenas,bangkok,7917);
        mapa.agregarConexion(moroni,bamako,6270);
        List<Ciudad> origenes = mapa.getOrigenes();
        assertEquals(3, origenes.size());
        assertEquals(atenas,origenes.get(0));
        assertEquals(bamako,origenes.get(1));
        assertEquals(moroni,origenes.get(2));
    }
}
