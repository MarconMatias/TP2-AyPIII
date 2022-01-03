package edu.fiuba.algo3.vista.Ciudad;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;

public class FotoCiudad extends Imagen {
    static final String base = "Ciudad/Foto_";
    public FotoCiudad(Ciudad ciudad) {
        super(pathDeCiudad(ciudad));
    }

    public static String pathDeCiudadTeorico(Ciudad ciudad) {
        return base + ciudad.getNombre().replace(" ", "_") + ".jpeg";
    }

    public static String urlDeRelativo(String path) {
        return Imagen.urlDesdeRecursos(path);
    }

    public static String pathDeCiudad(Ciudad ciudad) {
        String pathTeorico = pathDeCiudadTeorico(ciudad);
        String url = urlDeRelativo(pathTeorico);
        if(null == url) {
            //System.out.println("No pudo usarse foto: " + pathTeorico);
            url = urlDesdeRecursos("Ciudad/Ciudad_generica_1024.png");
        }
        return url;
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
