package edu.fiuba.algo3.modelo.Lector;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LectorLadronTest {
    @Test
    public void leerLadronesVacioDaListaVacia()
    {
        final String fuente = "{\"ladrones\":[]}";
        LectorLadron lector = new LectorLadron();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        List<Ladron> ladrones = lector.leerLadrones(entrada);
        assertEquals(0, ladrones.size());
    }

    @Test
    public void leer2ElementosDaListaCon2Ladrones()
    {
        String fuente = "{\"ladrones\":["+
                "{\"nombre\":\"Ladron1\",\"sexo\":\"\",\"deporte\":\"\",\"cabello\":\"\",\"distincion\":\"\",\"vehiculo\":\"\",},"+
                "{\"nombre\":\"Ladron2\",\"sexo\":\"\",\"deporte\":\"\",\"cabello\":\"\",\"distincion\":\"\",\"vehiculo\":\"\",},"+
                "]}";
        LectorLadron lector = new LectorLadron();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        List<Ladron> ladrones = lector.leerLadrones(entrada);
        assertEquals(2, ladrones.size());
    }

    @Test
    public void leer2ElementosDaListaCon2LadronesConNombreCorrecto()
    {
        String fuente = "{\"ladrones\":["+
                "{\"nombre\":\"Ladron1\",\"sexo\":\"\",\"deporte\":\"\",\"cabello\":\"\",\"distincion\":\"\",\"vehiculo\":\"\",},"+
                "{\"nombre\":\"Ladron2\",\"sexo\":\"\",\"deporte\":\"\",\"cabello\":\"\",\"distincion\":\"\",\"vehiculo\":\"\",},"+
                "]}";
        LectorLadron lector = new LectorLadron();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        List<Ladron> ladrones = lector.leerLadrones(entrada);
        assertEquals("Ladron1", ladrones.get(0).getNombre());
        assertEquals("Ladron2", ladrones.get(1).getNombre());
    }

    @Test
    public void leer2ElementosDaListaCon2LadronesConSexoCorrecto()
    {
        String fuente = "{\"ladrones\":["+
                "{\"nombre\":\"Ladron1\",\"sexo\":\"sexo1\",\"deporte\":\"\",\"cabello\":\"\",\"distincion\":\"\",\"vehiculo\":\"\",},"+
                "{\"nombre\":\"Ladron2\",\"sexo\":\"sexo2\",\"deporte\":\"\",\"cabello\":\"\",\"distincion\":\"\",\"vehiculo\":\"\",},"+
                "]}";
        LectorLadron lector = new LectorLadron();

        JSONObject entrada;
        try
        {
            entrada = (JSONObject) (new JSONParser()).parse(fuente);
        }
        catch(ParseException ex) {
            throw new RuntimeException("Error al parsear test: "+ex.toString());
        }
        List<Ladron> ladrones = lector.leerLadrones(entrada);
        assertEquals("sexo1", ladrones.get(0).getDetalle("sexo",""));
        assertEquals("sexo2", ladrones.get(1).getDetalle("sexo",""));
    }

}
