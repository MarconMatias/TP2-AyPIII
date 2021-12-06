package edu.fiuba.algo3.modelo.Edificio.Testigo;

import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestigoTest {
    @Test
    public void testigosConNombreTienenNombresDados()
    {
        Testigo testigo1 = new Testigo("nombre1",null);
        Testigo testigo2 = new Testigo("nombre2",null);
        assertEquals("nombre1", testigo1.getNombre());
        assertEquals("nombre2", testigo2.getNombre());
    }

    @Test
    public void testigoConFiltroNullSinLadronDevuelveNoVi()
    {
        Testigo testigo = new Testigo("testigoConFiltroNullSinLadronDevuelveNoVi",null);
        String testimonio = testigo.getTestimonio(null);
        assertTrue(testimonio.contains(" no vi "));
    }

    @Test
    public void testigoConFiltroNullSinLadronNoFiltra()
    {
        Testigo testigo = new Testigo("testigoConFiltroNullSinLadronNoFiltra",null);
        Policia policia = mock(Policia.class);
        String testimonio = testigo.getTestimonio(policia);
        verify(policia, never()).filtrarPistas(anyCollection());
        assertTrue(testimonio.contains(" no vi "));
    }

}
