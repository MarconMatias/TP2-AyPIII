package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.*;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestsCasosDeUsoEntrega2 {

    /**
     * Detective sufre una herida de cuchillo.
     * Detective duerme.
     */
    @Test
    public void casoDeUso01() {
        fail("Caso de uso incompleto.");
    }

    /**
     * Detective con rango Investigador toma caso de un robo viaja de Montreal a México.
     */
    @Test
    public void casoDeUso02() {
        // Dependencias (reales y mocks)
        Calendario calendario = mock(Calendario.class);
        Item item = mock(Item.class);
        Ladron ladron = mock(Ladron.class);
        List<String> ruta = List.of("Montreal","Ciudad de México");
        Computadora computadora = mock(Computadora.class);
        Mapa mapa = mock(Mapa.class);
        Ciudad Montreal = mock(Ciudad.class);
        Ciudad Mexico = mock(Ciudad.class);
        when(mapa.getCiudadPorNombre("Montreal")).thenReturn(Montreal);
        when(mapa.getCiudadPorNombre("Ciudad de México")).thenReturn(Mexico);
        Random random = mock(Random.class);

        // 10 arrestos debe ser investigador
        Policia policia = new Policia("Un investigador",10);

        // Crear caso/misión inicia en México con Policía investigador
        Mision mision = new Mision(policia,item,ladron,ruta,"Montreal",computadora,
                mapa,calendario,random);

        // VERIFICAR que se hayan actualizado las ciudades:
        verify(Montreal).actualizarRutaLadron(anyList(),eq(ladron));
        verify(Mexico).actualizarRutaLadron(anyList(),eq(ladron));
        verify(Montreal).visitadaPorPolicia(policia);

        // Viaja de Montreal a México
        mision.viajarACiudad("Ciudad de México");

        // VERIFICAR que se haya hecho el viaje:
        verify(mapa).viajar(policia,Montreal,"Ciudad de México");
        //verify(Mexico).visitadaPorPolicia(policia);
    }

    /**
     * Cargar en la computadora los datos recopilados y buscar sospechosos.
     */
    @Test
    public void casoDeUso03() {
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

    /**
     * Intentas atrapar al sospechoso sin la orden de arresto emitida.
     */
    @Test
    public void casoDeUso04() {
        fail("Caso de uso incompleto.");
    }

    /**
     * Un detective hace 6 Arrestos.
     * Toma un caso de un sospechoso que robó un Incan Gold Mask.
     * Realiza la investigación.
     * Emite la orden.
     * Atrapa al sospechoso
     */
    @Test
    public void casoDeUso05()
    {
        // Carga de mapa
        LectorCiudad lectorCiudad = new LectorCiudad();
        Map<String, Ciudad> ciudades = lectorCiudad.leerCiudades();
        Mapa mapa = new Mapa(ciudades);
        LectorMapa lectorMapa = new LectorMapa(mapa);
        lectorMapa.leerMapa(/*entradaMapa*/);

        // Entidades prefijadas en el caso de uso
        Policia policia = new Policia("Matute", 6, new Calendario());
        Item item = new Item("Incan Gold Mask","Lima");
        Ladron ladron = new Ladron("Nick Brunch", "masculino", "escalada de montaña", "negro", "anillo", "moto");
        List<String> ruta = new ArrayList<>(List.of("Lima","San Marino", "Montreal", "Bamako"));
        Random random = new Random(2021);
        Computadora computadora =new Computadora(new ArrayList<>(List.of(ladron)));
        Mision mision = new Mision(policia,item,ladron,ruta,item.getNombreCiudadDelRobo(),
                computadora, mapa,new Calendario(),random);

        List<Edificio> edificios;
        mision.getMensajeMision(); // Indica lugar e item robado y sexo del sospechoso.
        mision.agregarDetalleLadron("sexo","masculino");
        edificios = mision.obtenerEdificios();
        mision.visitarEdificio(edificios.get(0));
        mision.visitarEdificio(edificios.get(1));
        mision.visitarEdificio(edificios.get(2));
        mision.agregarDetalleLadron("deporte","escalada de montaña");
        mision.getCiudadesVecinas();
        mision.viajarACiudad("San Marino");
        edificios = mision.obtenerEdificios();
        mision.visitarEdificio(edificios.get(0));
        mision.visitarEdificio(edificios.get(1));
        mision.visitarEdificio(edificios.get(2));
        mision.agregarDetalleLadron("cabello","negro");
        mision.generarOrdenDeArresto();
        mision.getCiudadesVecinas();
        mision.viajarACiudad("Montreal");
        edificios = mision.obtenerEdificios();
        mision.visitarEdificio(edificios.get(0));
        mision.visitarEdificio(edificios.get(1));
        mision.visitarEdificio(edificios.get(2));
        mision.getCiudadesVecinas();
        mision.viajarACiudad("Bamako");
        edificios = mision.obtenerEdificios();
        mision.visitarEdificio(edificios.get(0));
        if(!mision.fueFinalizada()) {
            mision.visitarEdificio(edificios.get(1));
        }
        if(!mision.fueFinalizada()) {
            mision.visitarEdificio(edificios.get(2));
        }
        assertTrue(mision.fueFinalizada());
        assertTrue(mision.fueVictoria());
        assertEquals(7,policia.getArrestos());
    }
}
