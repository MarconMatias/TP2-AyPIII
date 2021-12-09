package edu.fiuba.algo3.modelo.Pista;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NivelPistaTest {
    @Test
    public void pistaFacilEsEquivalenteAPistaFacil()
    {
        NivelPista primero = new PistaFacil();
        NivelPista segundo = new PistaFacil();
        assertTrue(primero.esEquivalente(segundo));
        assertTrue(segundo.esEquivalente(primero));
    }

    @Test
    public void pistaMediaEsEquivalenteAPistaMedia()
    {
        NivelPista primero = new PistaMedia();
        NivelPista segundo = new PistaMedia();
        assertTrue(primero.esEquivalente(segundo));
        assertTrue(segundo.esEquivalente(primero));
    }

    @Test
    public void pistaDificilEsEquivalenteAPistaDificil()
    {
        NivelPista primero = new PistaDificil();
        NivelPista segundo = new PistaDificil();
        assertTrue(primero.esEquivalente(segundo));
        assertTrue(segundo.esEquivalente(primero));
    }

    @Test
    public void pistaFacilNoEsEquivalenteAPistaMediaODificil()
    {
        NivelPista facil = new PistaFacil();
        NivelPista media = new PistaMedia();
        NivelPista dificil = new PistaDificil();
        assertFalse(facil.esEquivalente(media));
        assertFalse(facil.esEquivalente(dificil));
    }

    @Test
    public void pistaMediaNoEsEquivalenteAPistaFacilODificil()
    {
        NivelPista facil = new PistaFacil();
        NivelPista media = new PistaMedia();
        NivelPista dificil = new PistaDificil();

        assertFalse(media.esEquivalente(facil));
        assertFalse(media.esEquivalente(dificil));
    }

    @Test
    public void pistaDificilNoEsEquivalenteAPistaFacilMedia()
    {
        NivelPista facil = new PistaFacil();
        NivelPista media = new PistaMedia();
        NivelPista dificil = new PistaDificil();

        assertFalse(dificil.esEquivalente(facil));
        assertFalse(dificil.esEquivalente(media));
    }

}
