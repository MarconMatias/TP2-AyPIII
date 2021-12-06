package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LectorItemTest {
    @Test
    public void leerItemsVacioDaListaVacia()
    {
        final String fuente = "{\"items\":[]}";
        LectorItem lector = new LectorItem();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }

        List<Item> items = lector.leerItems(entrada);
        assertEquals(0, items.size());
    }

    @Test
    public void leer2ElementosDaListaCon2Items()
    {
        String fuente = "{\"items\":[{\"nombre\":\"Nombre1\",\"ciudad\":\"Ciudad1\"},";
        fuente+= "{\"nombre\":\"Item2\",\"ciudad\":\"Otro lugar\"}]}";
        LectorItem lector = new LectorItem();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }

        List<Item> items = lector.leerItems(entrada);
        assertEquals(2,items.size());
    }

    @Test
    public void leer2ElementosDaListaCon2ItemsConNombreCorrecto()
    {
        String fuente = "{\"items\":[{\"nombre\":\"Nombre1\",\"ciudad\":\"Ciudad1\"},";
        fuente+= "{\"nombre\":\"Item2\",\"ciudad\":\"Otro lugar\"}]}";
        LectorItem lector = new LectorItem();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }

        List<Item> items = lector.leerItems(entrada);
        assertEquals("Nombre1",items.get(0).getNombre());
        assertEquals("Item2",items.get(1).getNombre());
    }

}
