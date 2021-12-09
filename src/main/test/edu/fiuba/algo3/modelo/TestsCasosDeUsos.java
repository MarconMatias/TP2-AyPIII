package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Acciones.AccionCuchilloUnica;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
<<<<<<< HEAD
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Banco;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Bolsa;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
=======
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Juego.Caso;
import edu.fiuba.algo3.modelo.Juego.Mapa;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.*;

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
        mockBancoDeMontreal.visitar(mockPolicia);
        mockCalendario.avanzarHoras(2);

        verify(mockPolicia).visitar(mockBancoDeMontreal, mockLadronFemenino);
        verify(mockBancoDeMontreal).visitadoPorLadron(mockLadronFemenino, mockCiudadDeMontreal);
        verify(mockBancoDeMontreal).visitar(mockPolicia);
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
        mockBanco.visitar(mockPolicia);

        verify(mockPolicia).visitar(mockBanco,mockLadron);
        verify(mockBanco).visitar(mockPolicia);

        mockPolicia.visitar(mockBiblioteca,mockLadron);
        mockBiblioteca.visitar(mockPolicia);

        verify(mockPolicia).visitar(mockBiblioteca,mockLadron);
        verify(mockBiblioteca).visitar(mockPolicia);
    }

    /**
     * Detective viaja de Montreal a México
     */
    @Test
    public void test03CasoDeUso3(){
        // Dependencias (reales y mock)
        Policia policia = mock(Policia.class);
        Item item = new Item("Algo robado en Montreal","Montreal");
        Ladron ladron = new Ladron("Gordo Valor",new HashMap<>());
        List<String> ruta = List.of("Montreal","Ciudad de México");
        Computadora computadora = mock(Computadora.class);
        Calendario calendario = new Calendario();
        Random random = new Random();

        Ciudad Mexico = new Ciudad("Ciudad de México",new ArrayList<>());
        Ciudad Montreal = new Ciudad("Montreal",new ArrayList<>());
        Map<String,Ciudad> ciudades = new HashMap<String,Ciudad>();
        ciudades.put("Ciudad de México",Mexico);
        ciudades.put("Montreal",Montreal);
        Mapa mapa = new Mapa(ciudades);
        mapa.agregarConexion("Montreal","Ciudad de México",1);

        // Creo una misión iniciando en Montreal:
        Mision mision = new Mision(policia,item,ladron,ruta,"Montreal",computadora,mapa,calendario,random);

        //Se despliega un menu que muestra las ciudades para viajar desde la ciudad actual donde se está
        mision.getCiudadesVecinas();
        //se elije una y se actualiza la referencia de la ciudad actual
        mision.viajarACiudad("Ciudad de México");

        assertEquals("Ciudad de México",mision.getNombreCiudadActual());
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
            mockAeropuerto.visitar(mockPolicia);
        }
        verify(mockPolicia, times(3)).visitar(mockAeropuerto,mockLadron);
        verify(mockAeropuerto, times (3)).visitar(mockPolicia);
        for(int i= 0 ; i<55; i++){
            mockPolicia.visitar(mockPuerto,mockLadron);
            mockPuerto.visitar(mockPolicia);
        }
        verify(mockPolicia, times(55)).visitar(mockPuerto,mockLadron);
        verify(mockPuerto, times(55)).visitar(mockPolicia);
    }

    @Test
    public void test05CasoDeUso5(){
        Policia mockPolicia = mock(Policia.class);
        AccionCuchilloUnica mockAccion = mock(AccionCuchilloUnica.class);
        mockPolicia.hacerAccion(mockAccion);
        verify(mockPolicia).hacerAccion(mockAccion);
        // Dormir
    }


<<<<<<< HEAD
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
=======
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
}
