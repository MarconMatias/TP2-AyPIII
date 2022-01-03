package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Pista.NivelPista.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InterpreteNivelPistaTest {
    @Test
    public void pistaConDificultad0EsFacil()
    {
        NivelPista pista = InterpreteNivelPista.crearConDificultad(0);
        assertTrue(pista instanceof PistaFacil);
    }

    @Test
    public void pistaConDificultad1EsMedia()
    {
        NivelPista pista = InterpreteNivelPista.crearConDificultad(1);
        assertTrue(pista instanceof PistaMedia);
    }

    @Test
    public void pistaConDificultad2EsDificil()
    {
        NivelPista pista = InterpreteNivelPista.crearConDificultad(2);
        assertTrue(pista instanceof PistaDificil);
    }
}
