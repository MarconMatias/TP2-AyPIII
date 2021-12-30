package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Lector.LectorCiudad;
import edu.fiuba.algo3.vista.Ciudad.FotoCiudad;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FotoCiudadTest {
    @Test
    public void cadaCiudadTieneUnaFoto() {
        final String fuente = "src/main/java/edu/fiuba/algo3/recursos/ciudades.json";
        LectorCiudad lectorCiudad = new LectorCiudad();
        List<Ciudad> ciudades = lectorCiudad.leerCiudades(fuente);
        for(Ciudad ciudad : ciudades) {
            String teorico = FotoCiudad.pathDeCiudadTeorico(ciudad);
            assertNotNull(FotoCiudad.urlDeRelativo(teorico),teorico);
        }
    }
}
