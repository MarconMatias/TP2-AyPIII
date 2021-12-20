package edu.fiuba.algo3.componentes.Radio;

import edu.fiuba.algo3.componentes.Imagen.Imagen;

public class Radio extends Imagen {

    public Radio() {
        super(urlDesdeRecursos("radio/radio_1160_inactivo_desel.png"));
        escalaProperty().set(0.5);
        anguloProperty().set(80);
    }
}