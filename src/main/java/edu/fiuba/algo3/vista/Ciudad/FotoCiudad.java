package edu.fiuba.algo3.vista.Ciudad;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

public class FotoCiudad extends Imagen {
    public FotoCiudad(Ciudad ciudad) {
        super(pathDeCiudad(ciudad));
    }

    private static String pathDeCiudad(Ciudad ciudad) {
        return urlDesdeRecursos("Ciudad/Ciudad_generica_1024.png");
    }
}
