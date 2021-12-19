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
        estado.hacerVictoria();
        assertTrue(estado.fueVictoria());
        assertTrue(estado.fueFinalizada());
    }

    @Test
    public void alHacerseDerrotaEsFinalizadaPeroNoVictoria() {
        EstadoMision estado = new EstadoMision();
        estado.hacerDerrota();
        assertTrue(estado.fueFinalizada());
        assertFalse(estado.fueVictoria());
    }

}
