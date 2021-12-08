package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.io.IOException;

public class TestsCasosDeUsos {

    //Casos de usos
    @Test

    public void test01CasoDeUso1() throws IOException {


    }

    @Test
    public void test02CasoDeUso2(){

        Policia mockPolicia = mock(Policia.class);
        Edificio mockBanco = mock(Edificio.class);
        Edificio mockBiblioteca = mock(Edificio.class);
        Ladron mockLadron = mock(Ladron.class);
        Calendario mockCalendario = mock(Calendario.class);

        mockPolicia.visitar(mockBanco,mockLadron);
        mockBanco.visitar(mockPolicia,mockCalendario);

        verify(mockPolicia).visitar(mockBanco,mockLadron);
        verify(mockBanco).visitar(mockPolicia,mockCalendario);

        mockPolicia.visitar(mockBiblioteca,mockLadron);
        mockBiblioteca.visitar(mockPolicia,mockCalendario);

        verify(mockPolicia).visitar(mockBiblioteca,mockLadron);
        verify(mockBiblioteca).visitar(mockPolicia,mockCalendario);
    }

    @Test
    public void test03CasoDeUso3(){

        Mision mockMision = mock(Mision.class);
        Ciudad mockCiudadActual = mock(Ciudad.class);
        //Se despliega un menu que muestra las ciudades para viajar desde la ciudad actual donde se está
        //se elije una y se actualiza la referencia de la ciudad actual
        /* (mockMision devolveria la ciudad vecina de ciudadActual y la actualizaria
        siendo esta ahora la actual) mockCiudadActual = */mockMision.viajarACiudad(mockCiudadActual,"Mexico");
        mockCiudadActual.getCiudadVecina("Mexico");

        verify(mockMision).viajarACiudad(mockCiudadActual,"Mexico");
        verify(mockCiudadActual).getCiudadVecina("Mexico");
        verify(mockMision, never()).viajarACiudad(mockCiudadActual,"Buenos Aires");

    }

    @Test
    public void test04CasoDeUso4(){

        Policia mockPolicia = mock(Policia.class);
        Edificio mockAeropuerto = mock(Edificio.class);
        Edificio mockPuerto = mock(Edificio.class);
        Calendario mockCalendario = mock(Calendario.class);
        Ladron mockLadron = mock(Ladron.class);

        mockPolicia.visitar(mockAeropuerto,mockLadron);
        mockPolicia.visitar(mockPuerto,mockLadron);

        verify(mockPolicia).visitar(mockAeropuerto,mockLadron);
        verify(mockPolicia).visitar(mockPuerto,mockLadron);

        verify(mockAeropuerto).visitar(mockPolicia,mockCalendario);
        verify(mockPuerto).visitar(mockPolicia,mockCalendario);
    }

}
