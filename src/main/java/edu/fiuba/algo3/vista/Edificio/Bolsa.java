package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.util.List;

public class Bolsa extends DestinoEdificio {
    private static final Image sel = new Image(urlDesdeRecursos("Edificio/Bolsa_sel.png"));
    private static final Image desel = new Image(urlDesdeRecursos("Edificio/Bolsa_desel.png"));
    private static final List<Point2D> posiblesCoordenadas = List.of(
            new Point2D(0.555,0.718), new Point2D(0.624,0.533)
    );

    public Bolsa(Edificio edificio) {
        super(sel, desel, edificio);
    }

    @Override
    public Point2D getCoordenadas() {
        return posiblesCoordenadas.get(getIndice(posiblesCoordenadas.size()));
    }
}
