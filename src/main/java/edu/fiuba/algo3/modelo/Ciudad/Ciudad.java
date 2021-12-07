package edu.fiuba.algo3.modelo.Ciudad;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Ciudad {

    private final String nombre;
    private final ArrayList<PistaCiudad> pistas;
    private final ArrayList<Ciudad> ciudadesVecinas;

    private int cantidadDeVisitas = 0;

    public Ciudad(String nombre, ArrayList<PistaCiudad> pistas, ArrayList<Ciudad> ciudadVecinas) {
        this.nombre = nombre;
        this.pistas = pistas;
        this.ciudadesVecinas = ciudadVecinas;
    }

    public boolean esLaCiudad(String nombre) {
        return this.nombre.equals(nombre);
    }

    public List<ITipoEdificio> edificiosAlAzar(int i) {
        return null;
    }

    public String pistaAlAzar(Policia unPolicia, IFiltroCiudad filtroCiudad) {
        return null;
    }

    public Ciudad getCiudadVecina(String nombreDeLaCiudadVecina) {

        Ciudad ciudadVecina = null;

        for ( Ciudad c : ciudadesVecinas ){
            if( c.esLaCiudad(nombreDeLaCiudadVecina) )
                ciudadVecina = c;
        }

        return ciudadVecina;
    }
}
