package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import org.json.simple.JSONArray;
import org.junit.Test;
import java.util.ArrayList;
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
}
