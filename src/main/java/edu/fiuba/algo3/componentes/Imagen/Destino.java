package edu.fiuba.algo3.componentes.Imagen;

import edu.fiuba.algo3.componentes.Trayecto.Trayecto;
import edu.fiuba.algo3.componentes.Binding.BooleanDoubleBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Destino extends ImagenSeleccionable {
    private static final double ordenSeleccionado = -20;
    private static final double ordenDeseleccionado = -19;
    private static final Image sel = new Image(urlDesdeRecursos("Ciudad/DestinoCiudad_640_sel.png"));
    private static final Image desel = new Image(urlDesdeRecursos("Ciudad/DestinoCiudad_640_desel.png"));
    private String nombre;
    private Trayecto trayecto;
    private ObjectProperty<Event> elegido = new SimpleObjectProperty<Event>(null);

    public Destino(Image imageSel, Image imageDesel, String nombre) {
        super(imageSel, imageDesel);
        BooleanDoubleBinding orden = new BooleanDoubleBinding(focusedProperty(),
                ordenSeleccionado,
                ordenDeseleccionado);
        viewOrderProperty().bind(orden);
        this.nombre = nombre;
        addEventHandler(MouseEvent.MOUSE_CLICKED, this::mouseClicked);
        addEventHandler(KeyEvent.KEY_PRESSED, this::keyPressed);
    }

    public Destino(String nombre) {
        this(getImageSel(), getImageDesel(), nombre);
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

    private void elegir(Event event) {
        elegido.set(event);
        event.isConsumed();
    }

    private void keyPressed(KeyEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(KeyCode.ENTER==event.getCode()) {
            elegir(event);
        }
    }

    protected static Image getImageDesel() {
        return desel;
    }

    protected static Image getImageSel() {
        return sel;
    }

    public String getNombre() {
        return nombre;
    }

    private void mouseClicked(MouseEvent event) {
        if(event.isConsumed()) {
            return;
        }
        if(1 == event.getButton().ordinal()) {
            elegir(event);
        }
    }

    public void setTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
