package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Juego.EstadoMision.EstadoMision;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoMisionTest {
    @Test
    public void alCrearseNoEsVictoriaNiFueFinalizada() {
        EstadoMision estado = new EstadoMision();
        assertFalse(estado.fueVictoria());
        assertFalse(estado.fueFinalizada());
    }

    @Test
    public void alHacerseVictoriaEsVictoriaYFinalizada() {
        EstadoMision estado = new EstadoMision();
        estado.hacerVictoria("");
        assertTrue(estado.fueVictoria());
        assertTrue(estado.fueFinalizada());
    }

    @Test
    public void alHacerseDerrotaEsFinalizadaPeroNoVictoria() {
        EstadoMision estado = new EstadoMision();
        estado.hacerDerrota("");
        assertTrue(estado.fueFinalizada());
        assertFalse(estado.fueVictoria());
    }

    @Test
    public void alHacerseDerrotayHacerVictoriaSigueSiendoDerrota() {
        EstadoMision estado = new EstadoMision();
        estado.hacerDerrota("");
        estado.hacerVictoria("");
        assertTrue(estado.fueFinalizada());
        assertFalse(estado.fueVictoria());
    }

    @Test
    public void alHacerseDerrota2vecesSigueSiendoDerrota() {
        EstadoMision estado = new EstadoMision();
        estado.hacerDerrota("");
        estado.hacerDerrota("");
        assertTrue(estado.fueFinalizada());
        assertFalse(estado.fueVictoria());
    }

    @Test
    public void alHacerseVictoriayHacerDerrotaSigueSiendoVictoria() {
        EstadoMision estado = new EstadoMision();
        estado.hacerVictoria("");
        estado.hacerDerrota("");
        assertTrue(estado.fueVictoria());
        assertTrue(estado.fueFinalizada());
    }

    @Test
    public void alHacerseVictoria2vecesSigueSiendoVictoria() {
        EstadoMision estado = new EstadoMision();
        estado.hacerVictoria("");
        estado.hacerVictoria("");
        assertTrue(estado.fueVictoria());
        assertTrue(estado.fueFinalizada());
    }

    @Test
    public void alHacerseVictoriaRetieneExplicacion() {
        EstadoMision estado = new EstadoMision();
        estado.hacerVictoria("¡Era Pepita La Pistolera!");
        assertEquals("¡Era Pepita La Pistolera!", estado.getExplicacion());
    }

    @Test
    public void alHacerseDerrotaRetieneExplicacion() {
        EstadoMision estado = new EstadoMision();
        estado.hacerVictoria("¡Era El Gordo Valor, no Pepita La Pistolera!");
        assertEquals("¡Era El Gordo Valor, no Pepita La Pistolera!", estado.getExplicacion());
    }
}
