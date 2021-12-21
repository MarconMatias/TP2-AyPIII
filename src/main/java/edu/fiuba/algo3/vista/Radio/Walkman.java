package edu.fiuba.algo3.vista.Radio;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Walkman extends Imagen {

    private RadioControlador controlador;
    private final BooleanProperty encendido = new SimpleBooleanProperty(true);
    private static List<Image> imgs = generarImage();

    private static List<Image> generarImage() {
        return Stream.of(
                "radio/radio_1160_inactivo_desel.png",
                "radio/radio_1160_inactivo_sel.png",
                "radio/radio_1160_activo_desel.png",
                "radio/radio_1160_activo_sel.png")
                .map(Walkman::urlDesdeRecursos).map(Image::new).collect(Collectors.toList());
    }

    public Walkman() {
        super(imgs.get(0));
        escalaProperty().set(0.5);
        anguloProperty().set(80);
        ColorAdjust brilloHover = new ColorAdjust();
        setEffect(brilloHover);
        DoubleBinding hoverBinding = new DoubleBinding() {
            {
                this.bind(hoverProperty());
            }

            @Override
            protected double computeValue() {
                return hoverProperty().get() ? 0.3 : 0.0;
            }
        };
        brilloHover.brightnessProperty().bind(hoverBinding);
        brilloHover.hueProperty().bind(hoverBinding);
        addEventHandler(MouseEvent.MOUSE_CLICKED, this::mouseClicked);
        setFocusTraversable(true);

        imageProperty().bind(new ObjectBinding<Image>() {
            {
                this.bind(focusedProperty(),encendido);
            }
            @Override
            protected Image computeValue() {
                int numeroImagen = (encendido.get()?2:0) + (focusedProperty().get()?1:0);
                return imgs.get(numeroImagen);
            }
        });
    }

    public Walkman(RadioControlador controlador) {
        this();
        this.controlador = controlador;
        controlador.bind(this);
    }

    private void mouseClicked(MouseEvent mouseEvent) {
        if(!isFocused()) {
            requestFocus();
            mouseEvent.consume();
            return;
        }
    }

}