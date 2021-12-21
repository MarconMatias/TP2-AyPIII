package edu.fiuba.algo3.componentes.Libro;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Librito extends Imagen {

    private final double viewOrder = -45;
    private final static Image sel = new Image(urlDesdeRecursos("Ciudad/Librito_sel.png"));
    private final static Image desel = new Image(urlDesdeRecursos("Ciudad/Librito_desel.png"));

    public Librito() {
        super(desel);
        this.setViewOrder(viewOrder);

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

    public Librito(double ancho) {
        this();
        double alto =  getImage().getHeight() * ancho/ getImage().getWidth();
        setFitHeight(alto);
        setFitWidth(ancho);
    }

    private void mouseClicked(MouseEvent mouseEvent) {
        if(!isFocused()) {
            requestFocus();
            mouseEvent.consume();
            return;
        }
    }

}
