package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Puerto extends DestinoEdificio {
    private static final Image sel = new Image(urlDesdeRecursos("Edificio/Puerto_sel.png"));
    private static final Image desel = new Image(urlDesdeRecursos("Edificio/Puerto_desel.png"));

    public Puerto(Edificio edificio) {
        super(sel, desel, edificio);
    }

    @Override
    public Point2D getCoordenadas() {
        return new Point2D(0.636,0.690);
    }
}
