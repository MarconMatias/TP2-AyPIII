package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

import java.util.List;

public class Biblioteca extends DestinoEdificio {
    private static final Image sel = new Image(urlDesdeRecursos("Edificio/Biblioteca_sel.png"));
    private static final Image desel = new Image(urlDesdeRecursos("Edificio/Biblioteca_desel.png"));
    private static final List<Point2D> posiblesCoordenadas = List.of(
            new Point2D(0.410,0.501), new Point2D(0.582,0.255)
    );

    public Biblioteca(Edificio edificio) {
        super(sel, desel, edificio);
    }

    @Override
    public Point2D getCoordenadas() {
        return posiblesCoordenadas.get(getIndice(posiblesCoordenadas.size()));
    }
}
