package edu.fiuba.algo3.vista.Ciudad;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

import java.io.File;

public class FotoCiudad extends Imagen {
    public FotoCiudad(Ciudad ciudad) {
        super(pathDeCiudad(ciudad));
    }

    private static String pathDeCiudad(Ciudad ciudad) {
        final String base = "src/main/java/edu/fiuba/algo3/recursos/Ciudad/Foto_";
        String buena = base + ciudad.getNombre().replace(" ", "_") + ".jpeg";
        File file = new File(buena);
        String url;
        if (file.exists()) {
            try {
                url = file.toURI().toURL().toString();
                return url;
            } catch (Exception ex) {
                System.err.println(ex.toString());
            }
        }
        System.out.println("No pudo usarse foto: " + buena);
        url = urlDesdeRecursos("Ciudad/Ciudad_generica_1024.png");
        return url;
    }
}
