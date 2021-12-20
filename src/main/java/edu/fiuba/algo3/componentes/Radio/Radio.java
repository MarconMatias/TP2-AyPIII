package edu.fiuba.algo3.componentes.Radio;

import edu.fiuba.algo3.componentes.Imagen.Imagen;

public class Radio extends Imagen {

    public Radio() {
        super(urlDesdeRecursos("radio/radio_1160_inactivo_desel.png"));
        setFitWidth(getFitWidth()/3);
        setFitHeight(getFitHeight()/3);
        anguloProperty().set(45);
    }
}