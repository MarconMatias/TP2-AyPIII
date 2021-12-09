package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.*;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Lector.*;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestsCasosDeUsoEntrega2 {
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
