package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class DestinoEdificio extends Destino {

    private final Edificio edificio;

    public DestinoEdificio(Image imageSel, Image imageDesel, Edificio edificio) {
        super(imageSel, imageDesel, edificio.getNombre());
        this.edificio = edificio;
    }

    protected DestinoEdificio(Edificio edificio) {
        this(getImageSel(), getImageDesel(), edificio);
    }

    public Point2D getCoordenada() {
        return new Point2D(0.5,0.5);
    }

}
