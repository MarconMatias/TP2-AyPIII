package edu.fiuba.algo3.vista.Mapa;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Libro.Librito;
import edu.fiuba.algo3.componentes.Mapamundi.Mapamundi;
import edu.fiuba.algo3.controlador.Mapa.MapaDestinosControlador;
import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Radio.Radio;
import edu.fiuba.algo3.vista.Radio.Walkman;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MapaDestinos extends Mapamundi {
    private final Juego juego;
    private final Mision mision;
    private final MapaDestinosControlador controlador;
    private final Librito librito;

    public MapaDestinos(Juego juego, Mision mision, MapaDestinosControlador controlador)
    {
        super();
        this.juego = juego;
        this.mision = mision;
        this.controlador = controlador;

        librito = new Librito(640);
        agregar(librito, 0.08, 0.4);

        setRadio(juego.getRadio());

        setControlador(controlador);
    }

    private void setControlador(MapaDestinosControlador controlador) {
        /** \todo. */
    }

    public void setRadio(Radio radio) {
        try {
            Walkman walkman = new Walkman(new RadioControlador(radio));
            agregar((Imagen) walkman, 0.026, 0.285);
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "Error al crear la radio, es posible que la escuche pero no pueda controlarla.", ButtonType.OK);
            alert.showAndWait();
        }
    }

}
