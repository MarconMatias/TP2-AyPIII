package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.vista.Edificio.DestinoEdificio;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Aeropuerto extends DestinoEdificio {
    private static final Image sel = new Image(urlDesdeRecursos("Edificio/Aeropuerto_sel.png"));
    private static final Image desel = new Image(urlDesdeRecursos("Edificio/Aeropuerto_desel.png"));

    public Aeropuerto(Edificio edificio) {
        super(sel, desel, edificio);
    }

    @Override
    public Point2D getCoordenadas() {
        return new Point2D(0.635,0.386);
    }
}
