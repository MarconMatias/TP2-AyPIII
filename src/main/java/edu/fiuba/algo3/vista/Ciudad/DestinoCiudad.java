package edu.fiuba.algo3.vista.Ciudad;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import javafx.geometry.Point2D;

public class DestinoCiudad extends Destino {
    private final Ciudad ciudad;

    public DestinoCiudad(Ciudad ciudad) {
        super(ciudad.getNombre());
        this.ciudad = ciudad;
        setWidth(96);
    }
    public Point2D getCoordenadas() {
        return new Point2D(ciudad.getCoordenadaX(), ciudad.getCoordenadaY());
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
