package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.Mapa;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestsCasosDeUsos {

    // Casos de usos
    @Test

    public void test01CasoDeUso1() throws IOException {

        Ladron mockLadronFemenino = mock(Ladron.class);
        Policia mockPolicia = mock(Policia.class);
        Edificio mockBancoDeMontreal = mock(Edificio.class);
        Ciudad mockCiudadDeMontreal = mock(Ciudad.class);
        Calendario mockCalendario = mock(Calendario.class);

        mockPolicia.visitar(mockBancoDeMontreal);
        mockBancoDeMontreal.visitadoPorLadron(mockLadronFemenino, mockCiudadDeMontreal);
        mockBancoDeMontreal.visitar(mockPolicia);
        mockCalendario.avanzarHoras(2);

        verify(mockPolicia).visitar(mockBancoDeMontreal);
        verify(mockBancoDeMontreal).visitadoPorLadron(mockLadronFemenino, mockCiudadDeMontreal);
        verify(mockBancoDeMontreal).visitar(mockPolicia);
        verify(mockCalendario).avanzarHoras(2);
    }

    @Test
    public void test02CasoDeUso2() {

        Policia mockPolicia = mock(Policia.class);
        Edificio mockBanco = mock(Edificio.class);
        Edificio mockBiblioteca = mock(Edificio.class);
        Ladron mockLadron = mock(Ladron.class);
        Calendario mockCalendario = mock(Calendario.class);

        mockPolicia.visitar(mockBanco);
        mockBanco.visitar(mockPolicia);

        verify(mockPolicia).visitar(mockBanco);
        verify(mockBanco).visitar(mockPolicia);

        mockPolicia.visitar(mockBiblioteca);
        mockBiblioteca.visitar(mockPolicia);

        verify(mockPolicia).visitar(mockBiblioteca);
        verify(mockBiblioteca).visitar(mockPolicia);
    }

    /**
     * Detective viaja de Montreal a México
     */
    @Test
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
            mockPolicia.visitar(mockAeropuerto);
            mockAeropuerto.visitar(mockPolicia);
        }
        verify(mockPolicia, times(3)).visitar(mockAeropuerto);
        verify(mockAeropuerto, times(3)).visitar(mockPolicia);
        for (int i = 0; i < 55; i++) {
            mockPolicia.visitar(mockPuerto);
            mockPuerto.visitar(mockPolicia);
        }
        verify(mockPolicia, times(55)).visitar(mockPuerto);
        verify(mockPuerto, times(55)).visitar(mockPolicia);
    }

    @Test
    public void test05CasoDeUso5() {
        Policia mockPolicia = mock(Policia.class);
        AccionCuchilloUnica mockAccion = mock(AccionCuchilloUnica.class);
        // Dormir
    }

    @Test
    public void test08CasoDeUso8() {

    }

}