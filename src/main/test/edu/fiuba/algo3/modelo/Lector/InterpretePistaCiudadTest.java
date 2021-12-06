package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InterpretePistaCiudadTest {
    @Test
    public void interpretarArrayVacioDaListaVacia()
    {
        InterpretePistaCiudad interprete = new InterpretePistaCiudad();
        JSONArray entrada = new JSONArray();
        ArrayList<PistaCiudad> salida = interprete.interpretar(entrada);
        assertEquals(0,salida.size());
    }

    @Test
    public void arrayCon3ElementosDaListaCon3Pistas()
    {
        InterpretePistaCiudad interprete = new InterpretePistaCiudad();
        String fuente = "[{\"tipo\":\"Bandera\",\"pista\":\"Verde, blanca y roja\",\"dificultad\":0},";
        fuente += "{\"tipo\":\"Comida\",\"pista\":\"Tacos\",\"dificultad\":0},";
        fuente += "{\"tipo\":\"Paisajes\",\"pista\":\"Monte Popocatepetl\",\"dificultad\":0}]";
        JSONArray entrada;
        try
        {
            entrada = (JSONArray) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        ArrayList<PistaCiudad> salida = interprete.interpretar(entrada);
        assertEquals(3,salida.size());
    }

    @Test
    public void arrayCon3ElementosDaListaCon3PistasDeTipoCorrecto()
    {
        InterpretePistaCiudad interprete = new InterpretePistaCiudad();
        String fuente = "[{\"tipo\":\"Bandera\",\"pista\":\"Verde, blanca y roja\",\"dificultad\":0},";
        fuente += "{\"tipo\":\"Comida\",\"pista\":\"Tacos\",\"dificultad\":0},";
        fuente += "{\"tipo\":\"Paisajes\",\"pista\":\"Monte Popocatepetl\",\"dificultad\":0}]";
        JSONArray entrada;
        try
        {
            entrada = (JSONArray) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        ArrayList<PistaCiudad> salida = interprete.interpretar(entrada);
        boolean primeroEsBandera = salida.get(0).esDeUnTipoDe(List.of("Bandera"));
        assertTrue(primeroEsBandera);
        assertTrue(salida.get(1).esDeUnTipoDe(List.of("Comida")));
        assertTrue(salida.get(2).esDeUnTipoDe(List.of("Paisajes")));
    }
}
