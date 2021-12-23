package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
<<<<<<< HEAD
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.Mapa;
=======
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Banco;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Biblioteca;
import edu.fiuba.algo3.modelo.Juego.Juego;
>>>>>>> ce92e3cf564b1cd7a8e01fd370036153672bccdd
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

public class TestsCasosDeUsos {

    // Casos de usos
    @Test

<<<<<<< HEAD
    public void test01CasoDeUso1() throws IOException {

        Ladron mockLadronFemenino = mock(Ladron.class);
        Policia mockPolicia = mock(Policia.class);
        Edificio mockBancoDeMontreal = mock(Edificio.class);
        Ciudad mockCiudadDeMontreal = mock(Ciudad.class);
        Calendario mockCalendario = mock(Calendario.class);

        mockPolicia.visitar(mockBancoDeMontreal, mockLadronFemenino);
        mockBancoDeMontreal.visitadoPorLadron(mockLadronFemenino, mockCiudadDeMontreal);
        mockBancoDeMontreal.visitar(mockPolicia);
        mockCalendario.avanzarHoras(2);

        verify(mockPolicia).visitar(mockBancoDeMontreal, mockLadronFemenino);
        verify(mockBancoDeMontreal).visitadoPorLadron(mockLadronFemenino, mockCiudadDeMontreal);
        verify(mockBancoDeMontreal).visitar(mockPolicia);
        verify(mockCalendario).avanzarHoras(2);
    }

    @Test
    public void test02CasoDeUso2() {
=======
    public void test01CasoDeUso1ElLadronRobaUnTesoroNacionalDeMontrealSospechosoFemeninoYDetectiveNovatoEncuentraPistaEnUnBanco() throws IOException {

        boolean policiaEntro = false;
        Policia nuevoPolicia = new Policia((new RangoPolicia()),"Agus");
        Ladron unLadron = new Ladron("Ada","Femenino","Jockey sobre Hielo","Rubio","anillo de oro","Moto");
        Banco banco = new Banco("Banco de Montreal"); //En vez de usar un campo true podria settearse con Strategy el comportamiento de un Edificio para que muestre una pista o no
        policiaEntro = nuevoPolicia.entraAlEdificio( banco, unLadron );
        assertTrue(policiaEntro);
    }

    @Test
    public void test02DetectiveComienzaEnMontrealVistaUnBancoSeDespliegaUnaPistaYLuegoVisitaUnaBibliotecaYSeDespliegaUnaPista(){
>>>>>>> ce92e3cf564b1cd7a8e01fd370036153672bccdd

        Policia mockPolicia = mock(Policia.class);
        Banco mockBanco = mock(Banco.class);
        Biblioteca mockBiblioteca = mock(Biblioteca.class);
        Ladron mockLadron = mock(Ladron.class);

<<<<<<< HEAD
        mockPolicia.visitar(mockBanco, mockLadron);
        mockBanco.visitar(mockPolicia);

        verify(mockPolicia).visitar(mockBanco, mockLadron);
        verify(mockBanco).visitar(mockPolicia);

        mockPolicia.visitar(mockBiblioteca, mockLadron);
        mockBiblioteca.visitar(mockPolicia);

        verify(mockPolicia).visitar(mockBiblioteca, mockLadron);
        verify(mockBiblioteca).visitar(mockPolicia);
=======
        mockPolicia.entraAlEdificio(mockBanco,mockLadron);
        mockBanco.mostrarPista(mockLadron);

        verify(mockPolicia).entraAlEdificio(mockBanco,mockLadron);
        verify(mockBanco).mostrarPista(mockLadron);

        mockPolicia.entraAlEdificio(mockBiblioteca,mockLadron);
        mockBiblioteca.mostrarPista(mockLadron);

        verify(mockPolicia).entraAlEdificio(mockBiblioteca,mockLadron);
        verify(mockBiblioteca).mostrarPista(mockLadron);
>>>>>>> ce92e3cf564b1cd7a8e01fd370036153672bccdd
    }

    /**
     * Detective viaja de Montreal a México
     */
    @Test
<<<<<<< HEAD
    public void test03CasoDeUso3() {
        // Dependencias (reales y mock)
        Policia policia = mock(Policia.class);
        Item item = new Item("Algo robado en Montreal", "Montreal");
        Ladron ladron = new Ladron("Gordo Valor", new HashMap<>());
        Computadora computadora = mock(Computadora.class);
        Calendario calendario = new Calendario();
        Random random = new Random();

        Ciudad Mexico = new Ciudad("Ciudad de México", new ArrayList<>());
        Ciudad Montreal = new Ciudad("Montreal", new ArrayList<>());
        List<Ciudad> ruta = List.of(Montreal, Mexico);
        Map<String, Ciudad> ciudades = new HashMap<String, Ciudad>();
        ciudades.put("Ciudad de México", Mexico);
        ciudades.put("Montreal", Montreal);
        Mapa mapa = new Mapa(ciudades);
        mapa.agregarConexion("Montreal", "Ciudad de México", 1);

        // Creo una misión iniciando en Montreal:
        Mision mision = new Mision(policia, item, ladron, ruta, "Montreal", computadora, mapa, calendario, random);

        // Se despliega un menu que muestra las ciudades para viajar desde la ciudad
        // actual donde se está
        mision.getCiudadesVecinas();
        // se elige una y se actualiza la referencia de la ciudad actual
        mision.viajarACiudad(Mexico);

        assertEquals("Ciudad de México", mision.getNombreCiudadActual());
    }

    @Test
    public void test04CasoDeUso4() {

        Policia mockPolicia = mock(Policia.class);
        Edificio mockAeropuerto = mock(Edificio.class);
        Ladron mockLadron = mock(Ladron.class);
        Edificio mockPuerto = mock(Edificio.class);
        Calendario mockCalendario = mock(Calendario.class);

        for (int i = 0; i < 3; i++) {
            mockPolicia.visitar(mockAeropuerto, mockLadron);
            mockAeropuerto.visitar(mockPolicia);
        }
        verify(mockPolicia, times(3)).visitar(mockAeropuerto, mockLadron);
        verify(mockAeropuerto, times(3)).visitar(mockPolicia);
        for (int i = 0; i < 55; i++) {
            mockPolicia.visitar(mockPuerto, mockLadron);
            mockPuerto.visitar(mockPolicia);
        }
        verify(mockPolicia, times(55)).visitar(mockPuerto, mockLadron);
        verify(mockPuerto, times(55)).visitar(mockPolicia);
    }

    @Test
    public void test05CasoDeUso5() {
        Policia mockPolicia = mock(Policia.class);
        AccionCuchilloUnica mockAccion = mock(AccionCuchilloUnica.class);
        mockPolicia.hacerAccion(mockAccion);
        verify(mockPolicia).hacerAccion(mockAccion);
        // Dormir
    }

    @Test
    public void test08CasoDeUso8() {

    }
=======
    public void test03DetectiveViajaDeMontrealAMexico(){

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

>>>>>>> ce92e3cf564b1cd7a8e01fd370036153672bccdd

}
