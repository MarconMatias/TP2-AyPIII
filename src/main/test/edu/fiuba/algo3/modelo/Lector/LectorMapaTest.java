package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ladron.Ladron;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LectorMapaTest {
    @Test
    public void leerJsonVacioDaOrigenesVacio() {
        final String fuente = "{\"mapa\":[]}";
        LectorLadron lector = new LectorMapa();
        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        List<Ladron> ladrones = lector.leerMapa(entrada);
        assertEquals(0, ladrones.getOrigenes().size());
    }
}
