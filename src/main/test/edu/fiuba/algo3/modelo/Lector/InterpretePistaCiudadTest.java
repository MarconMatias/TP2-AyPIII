package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import org.json.simple.JSONArray;
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
        assertFalse(salida.get(0).esDeUnTipoDe(List.of("Comida","Paisajes")));
        assertFalse(salida.get(1).esDeUnTipoDe(List.of("Bandera","Paisajes")));
        assertFalse(salida.get(2).esDeUnTipoDe(List.of("Bandera","Comida")));
    }

    @Test
    public void arrayCon3ElementosDaListaCon3PistasConValorCorrecto()
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
        assertEquals("Verde, blanca y roja", salida.get(0).getValor());
        assertEquals("Tacos", salida.get(1).getValor());
        assertEquals("Monte Popocatepetl", salida.get(2).getValor());
    }

    @Test
    public void arrayCon3ElementosDaListaCon3PistasConNivelCorrecto()
    {
        InterpretePistaCiudad interprete = new InterpretePistaCiudad();
        ArrayList<IPista> faciles = new ArrayList<IPista>();
        ArrayList<IPista> medias = new ArrayList<IPista>();
        ArrayList<IPista> dificiles = new ArrayList<IPista>();
        NivelPista facil = new PistaFacil();
        NivelPista media = new PistaMedia();
        NivelPista dificil = new PistaDificil();
        JSONArray entrada = null;

        String fuente = "[{\"tipo\":\"Bandera\",\"pista\":\"Verde, blanca y roja\",\"dificultad\":1},";
        fuente += "{\"tipo\":\"Comida\",\"pista\":\"Tacos\",\"dificultad\":2},";
        fuente += "{\"tipo\":\"Paisajes\",\"pista\":\"Monte Popocatepetl\",\"dificultad\":0}]";

        try
        {
            entrada = (JSONArray) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        ArrayList<PistaCiudad> salida = interprete.interpretar(entrada);
        for(IPista pista:salida)
        {
            pista.agregarAListaSiEsNivel(faciles,facil);
            pista.agregarAListaSiEsNivel(medias,media);
            pista.agregarAListaSiEsNivel(dificiles,dificil);
        }
        assertEquals(1, faciles.size());
        assertEquals(1, medias.size());
        assertEquals(1, dificiles.size());
        assertEquals("Verde, blanca y roja", ((PistaCiudad) medias.get(0)).getValor());
        assertEquals("Tacos", ((PistaCiudad) dificiles.get(0)).getValor());
        assertEquals("Monte Popocatepetl", ((PistaCiudad) faciles.get(0)).getValor());
    }
}
