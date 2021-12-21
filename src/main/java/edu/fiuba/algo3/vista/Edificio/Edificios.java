package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.controlador.Edificio.EdificiosControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
/**/
import edu.fiuba.algo3.modelo.Edificio.Edificio;

public class Edificios extends RelativoAImagen {
    private final Librito librito;

    public Edificios(Juego juego, Mision mision, EdificiosControlador controlador) {
        /** \todo Poner nombres de imágenes correctas cuando estén disponibles. **/
        super("src/main/java/edu/fiuba/algo3/recursos/Edificio/PlanoEdificios.jpeg");

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);

        /* \todo Destino a modo de ejemplo. */
        Edificio banco = new Edificio(new edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Banco());
        DestinoEdificio destinoBanco = new Banco(banco);
        agregar(destinoBanco, 0.5, 0.5);

        setRadio(juego.getRadio());
        setControlador(controlador);
    }

    private void setControlador(EdificiosControlador controlador) {
        if(null == controlador) {
            return;
        }
        librito.setOnMouseClicked(controlador::libritoClicked);
        librito.setOnKeyPressed(controlador::libritoKeyPressed);
        //edificioElegido.addListener(ev->controlador.edificioElegido(edificioElegido.get()));
    }
}
