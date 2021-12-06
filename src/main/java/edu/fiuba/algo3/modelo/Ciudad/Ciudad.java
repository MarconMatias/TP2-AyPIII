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

    private int cantidadDeVisitas = 0;

    public Ciudad(String nombre, ArrayList<PistaCiudad> pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
    }

    public void visitar() {
        //
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
}
