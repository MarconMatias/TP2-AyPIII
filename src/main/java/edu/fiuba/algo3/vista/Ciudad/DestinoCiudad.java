package edu.fiuba.algo3.vista.Ciudad;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class DestinoCiudad extends Destino {
    private final Ciudad ciudad;
    private Trayecto trayecto;
    private ObjectProperty<Event> elegido = new SimpleObjectProperty<Event>(null);

    public DestinoCiudad(Ciudad ciudad) {
        super(ciudad.getNombre());
        this.ciudad = ciudad;
        addEventHandler(MouseEvent.MOUSE_CLICKED, this::mouseClicked);
        addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
    }

    private void keyPressed(KeyEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(KeyCode.ENTER==event.getCode()) {
            elegir(event);
        }
    }

    private void mouseClicked(MouseEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(1 == event.getButton().ordinal()) {
            elegir(event);
        }
    }

    private void elegir(Event event) {
        elegido.set(event);
        event.isConsumed();
    }

    public Point2D getCoordenadas() {
        return new Point2D(ciudad.getCoordenadaX(), ciudad.getCoordenadaY());
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

    public Double anguloParaProgreso(double valorProgreso) {
        if(null == trayecto) {
            return null;
        }
        return trayecto.anguloEnProgreso(valorProgreso);
    }

    public ObjectProperty<Event> elegidoProperty() {
        return elegido;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
