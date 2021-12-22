package edu.fiuba.algo3.vista.Juego;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import edu.fiuba.algo3.modelo.Radio.Radio;
import edu.fiuba.algo3.vista.Radio.Walkman;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

public class Pantalla extends RelativoAImagen {
    private Walkman walkman = null;

    public Pantalla(Image imagen) {
        super(imagen);
    }

    public Pantalla(String path) {
        super(path);
    }

    /**
     * Devuelve el controlador de walkman.
      * @return La instancia o null si no hay.
     */
    protected Walkman getWalkman() {
        return walkman;
    }

    /**
     * Configura la radio para mostrar un Walkman.
     * @param radio Radio a asociar al walkman, o null para ocultarlo.
     */
    protected void setRadio(Radio radio) {
        if(null != walkman) {
            getChildren().remove(walkman);
            /* \todo liberar walkman anterior para que se desuscriba. */
        }
        if(null == radio) {
            walkman = null;
            return;
        }
        try {
            walkman = new Walkman(new RadioControlador(radio));
            agregar((Imagen) walkman, 0.026, 0.285);
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.WARNING, "Error al crear la radio, es posible que la escuche pero no pueda controlarla.", ButtonType.OK);
            alert.showAndWait();
        }
    }
}
