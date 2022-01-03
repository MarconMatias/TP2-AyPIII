package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Mapa;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LectorMapaTest {
    @Test
    public void leerJsonVacioDaOrigenesVacio() throws LectorException {
        final String fuente = "{\"mapa\":{}}";
        LectorMapa lector = new LectorMapa();
        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        Mapa mapa = lector.leerMapa(entrada, new Mapa(Collections.emptyList()));
        assertEquals(0, mapa.getOrigenes().size());
    }

    @Test
    public void leerJsonCon1OrigenTiene1Origen() throws LectorException {
        final String fuente = "{\"mapa\":{\"Atenas\":{\"Bangkok\":7917}}}";
        LectorMapa lector = new LectorMapa();
        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
            catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        Mapa mapa = lector.leerMapa(entrada, new Mapa(Collections.emptyList()));
        assertEquals(1, mapa.getOrigenes().size());
    }

    @Test
    public void leerJsonConVariosOrigenDestinoDevuelveMapaConDistanciasCorrectas() throws LectorException {
        final String fuente = "{\"mapa\": {"+
                "  \"Atenas\": { \"Bangkok\": 7917, \"New York\": 7920, \"Reykjavik\": 4160, \"Oslo\": 2606},"+
                "  \"Bamako\": { \"Montreal\": 7113, \"Moroni\": 6270, \"Tokyo\": 13657},"+
                "  \"Bangkok\": { \"Atenas\": 7917, \"Katmandú\": 2209, \"Kigali\": 7953, \"Tokyo\": 4603},"+
                "  \"Tokyo\": { \"Bamako\": 13657, \"Bangkok\": 4603, \"Ciudad de México\": 11307}"+
                "} }";
        Mapa mapa = mock(Mapa.class);
        LectorMapa lector = new LectorMapa();
        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        Mapa devuelto = lector.leerMapa(entrada, mapa);
        assertEquals(mapa, devuelto);
        verify(mapa).agregarConexion("Atenas","Bangkok",7917);
        verify(mapa).agregarConexion("Atenas","New York",7920);
        verify(mapa).agregarConexion("Atenas","Reykjavik",4160);
        verify(mapa).agregarConexion("Atenas","Oslo",2606);
        verify(mapa).agregarConexion("Bamako","Montreal",7113);
        verify(mapa).agregarConexion("Bamako","Moroni",6270);
        verify(mapa).agregarConexion("Bamako","Tokyo",13657);
        verify(mapa).agregarConexion("Bangkok","Atenas",7917);
        verify(mapa).agregarConexion("Bangkok","Katmandú",2209);
        verify(mapa).agregarConexion("Bangkok","Kigali",7953);
        verify(mapa).agregarConexion("Bangkok","Tokyo",4603);
        verify(mapa).agregarConexion("Tokyo","Bamako",13657);
        verify(mapa).agregarConexion("Tokyo","Bangkok",4603);
        verify(mapa).agregarConexion("Tokyo","Ciudad de México",11307);
    }

}
