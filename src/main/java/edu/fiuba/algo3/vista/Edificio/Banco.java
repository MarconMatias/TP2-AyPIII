package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import javafx.scene.image.Image;

public class Banco extends DestinoEdificio {
    private static final Image sel = new Image(urlDesdeRecursos("Edificio/Banco_sel.png"));
    private static final Image desel = new Image(urlDesdeRecursos("Edificio/Banco_desel.png"));

    protected Banco(Edificio edificio) {
        super(sel, desel, edificio);
    }

}
