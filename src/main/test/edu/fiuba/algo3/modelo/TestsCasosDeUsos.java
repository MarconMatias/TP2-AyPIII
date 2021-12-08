package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Banco;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Bolsa;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.Caso;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;

public class TestsCasosDeUsos {

    //Casos de usos
    @Test

    public void test01CasoDeUso1() throws IOException {

        Ladron mockLadronFemenino = mock(Ladron.class);
        Policia mockPolicia = mock(Policia.class);
        Edificio mockBancoDeMontreal = mock(Edificio.class);
        Ciudad mockCiudadDeMontreal = mock(Ciudad.class);
        Calendario mockCalendario = mock(Calendario.class);

        mockPolicia.visitar(mockBancoDeMontreal, mockLadronFemenino);
        mockBancoDeMontreal.visitadoPorLadron(mockLadronFemenino, mockCiudadDeMontreal);
        mockBancoDeMontreal.visitar(mockPolicia, mockCalendario);
        mockCalendario.avanzarHoras(2);

        verify(mockPolicia).visitar(mockBancoDeMontreal, mockLadronFemenino);
        verify(mockBancoDeMontreal).visitadoPorLadron(mockLadronFemenino, mockCiudadDeMontreal);
        verify(mockBancoDeMontreal).visitar(mockPolicia, mockCalendario);
        verify(mockCalendario).avanzarHoras(2);
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
        Ladron mockLadron = mock(Ladron.class);
        Edificio mockPuerto = mock(Edificio.class);
        Calendario mockCalendario = mock(Calendario.class);

        for(int i = 0; i<3 ; i++){
            mockPolicia.visitar(mockAeropuerto,mockLadron);
            mockAeropuerto.visitar(mockPolicia,mockCalendario);
        }
        verify(mockPolicia, times(3)).visitar(mockAeropuerto,mockLadron);
        verify(mockAeropuerto, times (3)).visitar(mockPolicia,mockCalendario);
        for(int i= 0 ; i<55; i++){
            mockPolicia.visitar(mockPuerto,mockLadron);
            mockPuerto.visitar(mockPolicia,mockCalendario);
        }
        verify(mockPolicia, times(55)).visitar(mockPuerto,mockLadron);
        verify(mockPuerto, times(55)).visitar(mockPolicia,mockCalendario);
    }

    @Test
    public void test05CasoDeUso5(){
        Policia mockPolicia = mock(Policia.class);
        AccionCuchilloUnica mockAccion = mock(AccionCuchilloUnica.class);
        mockPolicia.hacerAccion(mockAccion);
        verify(mockPolicia).hacerAccion(mockAccion);
        // Dormir
    }

    @Test
    public void test07CasoDeUso7(){

        Policia mockDetective = mock(Policia.class);
        Caso mockCaso = mock(Caso.class);
        Ciudad mockCiudadActual = mock(Ciudad.class);

        Mision mockMision = mock(Mision.class);
        mockDetective.tomarCaso(mockCaso); //En realidad .tomarCaso() devuelve la mision para que luego dentro de la mision se viaje
        mockMision.viajarACiudad(mockCiudadActual,"Mexico");

        verify(mockDetective).tomarCaso(mockCaso);
        verify(mockMision).viajarACiudad(mockCiudadActual,"Mexico");
    }

    @Test
    public void test08CasoDeUso8(){

        //Antes la computadora ya esta cargada desde el inicio del juego con los sospechosos

        ArrayList<Ladron> ladrones = new ArrayList<>();
        Ladron ladronFemenino = new Ladron("Ana","femenino","Hockey sobre cesped","Rubio","Anillo de oro", "Moto");
        Ladron ladronMasculino = new Ladron("Agus","masculino","Fulbo","Castaño oscuro","Cadena de plata con dibujo de carpincho", "Moto");

        ladrones.add(ladronFemenino);
        ladrones.add(ladronMasculino);
        Computadora computadora = new Computadora(ladrones);

        computadora.agregarDetalle("sexo", "femenino");
        ArrayList<Ladron> sospechosos = computadora.buscarSospechosos();
        Assert.assertTrue(sospechosos.contains(ladronFemenino));
        Assert.assertEquals(1,sospechosos.size());


    }

    @Test
    public void test09CasoDeUso9(){

        Policia unPolicia = new Policia(new RangoPolicia(),"Mati");

        Mision mision = new Mision( unPolicia );
        Assert.assertFalse(mision.arrestar());

    }

    @Test
    public void test10CasoDeUso10(){

        Policia unPolicia = new Policia("Mati",6);
        Item incanGoldMask = new Item("Incan Gold Mask","Lima");
        Ladron unLadron = new Ladron("Ana","femenino","Tenis","Rubio","Falta con estampa de carpincho","Moto");
        ArrayList<Edificio> edificios = new ArrayList<Edificio>();
        edificios.add(new Edificio( new Banco("Banco de Lima"),new Bancario()));
        edificios.add(new Edificio( new Aeropuerto("Aeropuerto de Lima")));
        edificios.add(new Edificio( new Bolsa()));

        Ciudad unaCiudad = new Ciudad("Lima",null,null,edificios);

        Assert.assertTrue(unaCiudad.visitar("Banco de Lima",unLadron,unPolicia));

    }
}
