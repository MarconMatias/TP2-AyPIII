package edu.fiuba.algo3.vista.Ciudad;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Libro;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Radio.Radio;
import edu.fiuba.algo3.vista.Radio.Walkman;

public class LibroCiudad extends Libro {
    public LibroCiudad(Ciudad ciudad) {
        super();
    }

    public LibroCiudad(Ciudad ciudad, Radio radio) {
        this(ciudad);
        setRadio(radio);
    }

    public void setRadio(Radio radio) {
        Walkman walkman = new Walkman();
        agregar((Imagen) walkman, 0.026, 0.285);
    }
}
