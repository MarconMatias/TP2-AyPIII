package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Banco;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Biblioteca;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Puerto;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class TestsCasosDeUsos {

    //Casos de usos
    @Test

    public void test01CasoDeUso1() throws IOException {

        boolean policiaEntro = false;
        Policia nuevoPolicia = new Policia((new RangoPolicia()),"Agus");
        Ladron unLadron = new Ladron("Ada","Femenino","Jockey sobre Hielo","Rubio","anillo de oro","Moto");
        Banco banco = new Banco("Banco de Montreal"); //En vez de usar un campo true podria settearse con Strategy el comportamiento de un Edificio para que muestre una pista o no
        policiaEntro = nuevoPolicia.entraAlEdificio( banco, unLadron );
        assertTrue(policiaEntro);
    }

    @Test
    public void test02CasoDeUso2(){

        Policia mockPolicia = mock(Policia.class);
        Banco mockBanco = mock(Banco.class);
        Biblioteca mockBiblioteca = mock(Biblioteca.class);
        Ladron mockLadron = mock(Ladron.class);

        mockPolicia.entraAlEdificio(mockBanco,mockLadron);
        mockBanco.mostrarPista(mockLadron);

        verify(mockPolicia).entraAlEdificio(mockBanco,mockLadron);
        verify(mockBanco).mostrarPista(mockLadron);

        mockPolicia.entraAlEdificio(mockBiblioteca,mockLadron);
        mockBiblioteca.mostrarPista(mockLadron);

        verify(mockPolicia).entraAlEdificio(mockBiblioteca,mockLadron);
        verify(mockBiblioteca).mostrarPista(mockLadron);
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
        Aeropuerto mockAeropuerto = mock(Aeropuerto.class);
        Ladron mockLadron = mock(Ladron.class);
        Puerto mockPuerto = mock(Puerto.class);
        mockPolicia.entraAlEdificio(mockAeropuerto,mockLadron);
        mockAeropuerto.mostrarPista(mockLadron);

        verify(mockPolicia).entraAlEdificio(mockAeropuerto,mockLadron);
        verify(mockAeropuerto).mostrarPista(mockLadron);

        mockPolicia.entraAlEdificio(mockPuerto,mockLadron);
        mockPuerto.mostrarPista(mockLadron);

        verify(mockPolicia).entraAlEdificio(mockPuerto,mockLadron);
        verify(mockPuerto).mostrarPista(mockLadron);
    }


}
