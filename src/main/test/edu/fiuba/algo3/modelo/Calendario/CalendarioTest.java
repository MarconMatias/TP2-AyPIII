package edu.fiuba.algo3.modelo.Calendario;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalendarioTest {
    @Test
    public void alCrearCalendarioEs7HsDelLunes()
    {
        Calendario cal = new Calendario();
        assertEquals(1, cal.getDiaDeLaSemana());
        assertEquals(7, cal.getHoraDelDia());
    }

    @Test
    public void alCrearCalendarioPasaron0Dias()
    {
        Calendario cal = new Calendario();
        assertEquals(0, cal.getCantidadDeDias());
    }

    @Test
    public void AlAvanzar1HoraEs8HsDelLunesDia0() throws AccionException, CalendarioException {
        Calendario cal = new Calendario();
        cal.avanzarHoras(1);
        assertEquals(1, cal.getDiaDeLaSemana());
        assertEquals(8, cal.getHoraDelDia());
        assertEquals(0, cal.getCantidadDeDias());
    }

    @Test
    public void AlAvanzar14HorasEs21HsDelLunesDia0() throws AccionException, CalendarioException {
        Calendario cal = new Calendario();
        cal.avanzarHoras(14);
        assertEquals(1, cal.getDiaDeLaSemana());
        assertEquals(21, cal.getHoraDelDia());
        assertEquals(0, cal.getCantidadDeDias());
    }

    @Test
    public void AlAvanzar15HorasEs6HsDelMartesDia1() throws AccionException, CalendarioException {
        Calendario cal = new Calendario();
        cal.avanzarHoras(15);
        assertEquals(2, cal.getDiaDeLaSemana());
        assertEquals(6, cal.getHoraDelDia());
        assertEquals(1, cal.getCantidadDeDias());
    }

    @Test
    public void AlAvanzar13HorasLuego2Es6HsDelMartesDia1() throws AccionException, CalendarioException {
        Calendario cal = new Calendario();
        cal.avanzarHoras(13);
        cal.avanzarHoras(2);
        assertEquals(2, cal.getDiaDeLaSemana());
        assertEquals(6, cal.getHoraDelDia());
        assertEquals(1, cal.getCantidadDeDias());
    }

    @Test
    public void AlAvanzar16HorasLuego2Es9HsDelMartesDia1() throws AccionException, CalendarioException {
        Calendario cal = new Calendario();
        cal.avanzarHoras(16);
        cal.avanzarHoras(2);
        assertEquals(2, cal.getDiaDeLaSemana());
        assertEquals(9, cal.getHoraDelDia());
        assertEquals(1, cal.getCantidadDeDias());
    }

    @Test
<<<<<<< HEAD
    public void test() throws AccionException, CalendarioException {
=======
    public void alAvanzar62horasEsMiercoles() {
>>>>>>> 365b5fa3a3e0a4979651d3eb358fddbe3c492721
        Calendario cal = new Calendario();
        cal.avanzarHoras(62);
        assertEquals(3, cal.getDiaDeLaSemana());
    }

}
