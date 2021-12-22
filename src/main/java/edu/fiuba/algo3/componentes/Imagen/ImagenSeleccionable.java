package edu.fiuba.algo3.componentes.Imagen;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class ImagenSeleccionable extends Imagen {
    public ImagenSeleccionable(Image sel, Image desel) {
        super(sel);
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
                this.bind(focusedProperty());
            }
            @Override
            protected Image computeValue() {
                return focusedProperty().get()? sel : desel;
            }
        });
    }

    public void setWidth(double ancho) {
        double alto =  getImage().getHeight() * ancho/ getImage().getWidth();
        setFitHeight(alto);
        setFitWidth(ancho);
    }

    private void mouseClicked(MouseEvent mouseEvent) {
        if(!isFocused()) {
            requestFocus();
            mouseEvent.consume();
        }
    }
}
