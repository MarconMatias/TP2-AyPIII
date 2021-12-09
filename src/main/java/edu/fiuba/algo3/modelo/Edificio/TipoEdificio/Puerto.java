package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Pista.Filtro.*;

<<<<<<< HEAD
public class Puerto implements ITipoEdificio {


    private final String nombre;

    public Puerto(String nombre){
        this.nombre = nombre;
    }
    @Override
    public String getNombreTipo() {
        return nombre;
=======
public class Puerto extends EdificioAbstracto{
    public Puerto() {
        super(new SinFiltro());
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
    }

    @Override
    public String getNombreTipo() {
        return "Puerto";
    }

    @Override
    protected String getNombreTestigo() {
        return "Marino";
    }


}

