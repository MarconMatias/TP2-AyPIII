package edu.fiuba.algo3.componentes.Radio;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Radio extends Imagen {

    private BooleanProperty encendido = new SimpleBooleanProperty(true);
    private static List<Image> imgs = generarImage();

    private static List<Image> generarImage() {
        return Stream.of(
                "radio/radio_1160_inactivo_desel.png",
                "radio/radio_1160_inactivo_sel.png",
                "radio/radio_1160_activo_sel.png",
                "radio/radio_1160_activo_desel.png")
                .map(Radio::urlDesdeRecursos).map(Image::new).collect(Collectors.toList());
    }

    public Radio() {
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
        super.setOnMouseClicked(this::mouseClicked);
    }

    private void mouseClicked(MouseEvent mouseEvent) {
        requestFocus();
        System.out.println();
    }
}