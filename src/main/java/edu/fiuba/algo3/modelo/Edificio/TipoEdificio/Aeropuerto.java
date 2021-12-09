package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Pista.Filtro.*;

<<<<<<< HEAD
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;


public class Aeropuerto extends EdificioAbstracto{

    private final String nombre;

    public Aeropuerto(String nombreAeropuerto) {
        this.nombre = nombreAeropuerto;
    }

    @Override
    public String getNombreTipo() {
        return nombre;
    }

    @Override
    public Testigo getTestigo() {
        return null;
    }

    @Override
    protected String getNombreTestigo() {
        return null;
    }

    @Override
    public boolean mostrarPista(Ladron unLadron) {
        return false;
=======
public class Aeropuerto extends EdificioAbstracto{
    public Aeropuerto() {
        super(new SinFiltro());
    }

    @Override
    public String getNombreTipo() {
        return "Aeropuerto";
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
    }

    @Override
    protected String getNombreTestigo() {
        return "Piloto";
    }


}

