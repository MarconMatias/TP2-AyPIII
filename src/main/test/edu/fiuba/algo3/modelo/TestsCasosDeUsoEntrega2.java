package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Calendario.Acciones.AccionDormir;
import edu.fiuba.algo3.modelo.Calendario.Acciones.HeridaPorCuchillo;
import edu.fiuba.algo3.modelo.Calendario.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Ciudad.Mapa;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Lector.LectorCiudad;
import edu.fiuba.algo3.modelo.Lector.LectorMapa;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        // Poner calendario en 21 hs para que al recibir herida deba dormir:
        Calendario calendario = new Calendario();
        int horaInicial = 7;
        int horaDeseada = 21;
        calendario.avanzarHoras(horaDeseada-horaInicial);
        // Observador:
        IObservadorAcciones observador = mock(IObservadorAcciones.class);
        calendario.observarAcciones(observador);
        // Policía debe ser detective:
        int arrestosParaDetective = 5;
        Policia policia = new Policia("Un detective", arrestosParaDetective, calendario);

        IAccion herida = new HeridaPorCuchillo();
        policia.realizarAccion(herida);

        verify(observador).accionRealizada(any(AccionDormir.class));
        verify(observador).accionRealizada(any(HeridaPorCuchillo.class));
    }

    /**
     * Detective con rango Investigador toma caso de un robo viaja de Montreal a México.
     */
    @Test
    public void casoDeUso02() {
        // Dependencias (reales y mocks)
        Calendario calendario = new Calendario();
        Item item = mock(Item.class);
        Ladron ladron = mock(Ladron.class);
        Computadora computadora = mock(Computadora.class);
        Ciudad Montreal = mock(Ciudad.class);
        when(Montreal.getNombre()).thenReturn("Montreal");
        Ciudad Mexico = mock(Ciudad.class);
        when(Mexico.getNombre()).thenReturn("Ciudad de México");
        List<Ciudad> ruta = List.of(Montreal,Mexico);
        Mapa mapa = mock(Mapa.class);
        when(mapa.getCiudadPorNombre("Montreal")).thenReturn(Montreal);
        when(mapa.getCiudadPorNombre("Ciudad de México")).thenReturn(Mexico);
        Random random = mock(Random.class);

        // Preparo investigador
        int arrestosParaSerInvestigador = 10;
        Policia policia = new Policia("Un investigador",arrestosParaSerInvestigador);

        // Crear caso/misión inicia en México con Policía investigador
        Mision mision = new Mision(policia,item,ladron,ruta,"Montreal",computadora,
                mapa,calendario,random);

        // VERIFICAR que se hayan actualizado las ciudades:
        verify(Montreal).actualizarRutaLadron(any(),eq(ladron));
        verify(Mexico).actualizarRutaLadron(any(),eq(ladron));
        verify(Montreal).visitadaPorPolicia(policia, random);

        // Viaja de Montreal a México
        mision.viajarACiudad(Mexico);

        // VERIFICAR que se haya hecho el viaje:
        verify(mapa).viajar(policia,Montreal,Mexico,random);
        //verify(Mexico).visitadaPorPolicia(policia); // No funciona porque mapa es un mock
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
        // Dependencias (reales y mocks)
        Calendario calendario = new Calendario();
        Item item = mock(Item.class);
        Ladron ladron = mock(Ladron.class);
        Computadora computadora = mock(Computadora.class);

        Ciudad Mexico = new Ciudad("Ciudad de México",new ArrayList<>());
        Ciudad Montreal = new Ciudad("Montreal",new ArrayList<>());
        List<Ciudad> ruta = List.of(Montreal,Mexico);
        Map<String,Ciudad> ciudades = new HashMap<String,Ciudad>();
        ciudades.put("Ciudad de México",Mexico);
        ciudades.put("Montreal",Montreal);
        Mapa mapa = new Mapa(ciudades);
        mapa.agregarConexion("Montreal","Ciudad de México",1);

        Random random = mock(Random.class);

        // Preparo investigador
        int arrestosParaSerInvestigador = 10;
        Policia policia = new Policia("Un investigador",arrestosParaSerInvestigador);

        // Crear caso/misión inicia en México con Policía investigador
        Mision mision = new Mision(policia,item,ladron,ruta,"Montreal",computadora,
                mapa,calendario,random);

        // Viaja de Montreal a México, donde al ser ruta final debería estar el ladrón
        mision.viajarACiudad(Mexico);

        List<Edificio> edificios = mision.obtenerEdificios();
        for(Edificio edificio : edificios) {
            if(mision.fueFinalizada()) {
                break;
            }
            mision.visitarEdificio(edificio);
        }

        // La cantidad de arrestos no cambió, la misión terminó y NO fue una victoria.
        assertEquals(arrestosParaSerInvestigador,policia.getArrestos());
        assertFalse(mision.fueVictoria());
        assertTrue(mision.fueFinalizada());
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
        LectorMapa lectorMapa = new LectorMapa();
        lectorMapa.leerMapa(/*entradaMapa,*/mapa);

        // Entidades prefijadas en el caso de uso
        Policia policia = new Policia("Matute", 6, new Calendario());
        Item item = new Item("Incan Gold Mask","Lima");
        Ladron ladron = new Ladron("Nick Brunch", "masculino", "escalada de montaña", "negro", "anillo", "moto");
        Ciudad lima = mapa.getCiudadPorNombre("Lima");
        Ciudad sanMarino = mapa.getCiudadPorNombre("San Marino");
        Ciudad montreal = mapa.getCiudadPorNombre("Montreal");
        Ciudad bamako = mapa.getCiudadPorNombre("Bamako");
        List<Ciudad> ruta = new ArrayList<>(List.of(lima,sanMarino, montreal, bamako));
        Random random = new Random(2021);
        Computadora computadora =new Computadora(new ArrayList<>(List.of(ladron)));
        Mision mision = new Mision(policia,item,ladron,ruta,item.getNombreCiudadDelRobo(),
                computadora, mapa,new Calendario(),random);

        mision.getMensajeMision(); // Indica lugar e item robado y sexo del sospechoso.
        mision.agregarDetalleLadron("sexo","masculino");

        List<Edificio> edificios = mision.obtenerEdificios();
        for(Edificio edificio : edificios) {
            mision.visitarEdificio(edificio);
        }
        mision.agregarDetalleLadron("deporte","escalada de montaña");

        // Solicitar ciudades, viajar a San Marino y visitar todos los edificios
        mision.getCiudadesVecinas();
        mision.viajarACiudad(sanMarino);
        edificios = mision.obtenerEdificios();
        for(Edificio edificio : edificios) {
            mision.visitarEdificio(edificio);
        }
        // Agregar detalle y solicitar orden de arresto
        mision.agregarDetalleLadron("cabello","negro");
        mision.generarOrdenDeArresto();

        // Solicitar ciudades, viajar a Montreal y visitar todos los edificios
        mision.getCiudadesVecinas();
        mision.viajarACiudad(montreal);
        edificios = mision.obtenerEdificios();
        for(Edificio edificio : edificios) {
            mision.visitarEdificio(edificio);
        }

        // Solicitar ciudades, viajar a Bamako y visitar todos los edificios
        mision.getCiudadesVecinas();
        mision.viajarACiudad(bamako);
        edificios = mision.obtenerEdificios();
        for(Edificio edificio : edificios) {
            if(mision.fueFinalizada()) {
                break;
            }
            mision.visitarEdificio(edificio);
        }

        // La cantidad de arrestos aumentó en 1, la misión terminó y SÍ fue una victoria.
        assertEquals(7,policia.getArrestos());
        assertTrue(mision.fueFinalizada());
        assertTrue(mision.fueVictoria());
    }
}
