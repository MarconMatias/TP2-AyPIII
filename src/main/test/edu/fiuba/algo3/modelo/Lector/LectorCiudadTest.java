package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class LectorCiudadTest {

    @Test
    public void leerCiudadesVacioDaMapaVacio()
    {
        final String fuente = "{\"ciudades\":[]}";
        LectorCiudad lector = new LectorCiudad();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        Map<String, Ciudad> ciudades = lector.leerCiudades(entrada);
        assertEquals(0, ciudades.size());
    }

    @Test
    public void leer2CiudadesDaMapa2Ciudades()
    {
        final String fuente = "{\"ciudades\":[{\"nombre\":\"Ciudad1\",\"pistas\":[]},{\"nombre\":\"Ciudad2\",\"pistas\":[]}]}";
        LectorCiudad lector = new LectorCiudad();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        Map<String, Ciudad> ciudades = lector.leerCiudades(entrada);
        assertEquals(2, ciudades.size());
    }

    @Test
    public void leer2CiudadesDaMapa2CiudadesConNombreCorrecto()
    {
        final String fuente = "{\"ciudades\":[{\"nombre\":\"Ciudad1\",\"pistas\":[]},{\"nombre\":\"Ciudad2\",\"pistas\":[]}]}";
        LectorCiudad lector = new LectorCiudad();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        Map<String, Ciudad> ciudades = lector.leerCiudades(entrada);
        assertTrue(ciudades.containsKey("Ciudad1"));
        assertTrue(ciudades.containsKey("Ciudad2"));
    }


}
