package edu.fiuba.algo3.modelo.Edificio.Testigo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestigoTest {
    @Test
    public void testigosConNombreTienenNombresDados()
    {
        Testigo testigo1 = new Testigo("nombre1",null);
        Testigo testigo2 = new Testigo("nombre2",null);
        assertEquals("nombre1", testigo1.getNombre());
        assertEquals("nombre2", testigo2.getNombre());
    }


}
