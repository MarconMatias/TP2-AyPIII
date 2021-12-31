package edu.fiuba.algo3.vista.Juego;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.componentes.Imagen.Tarjetas;
import edu.fiuba.algo3.componentes.RelativoAImagen.RelativoAImagen;
import edu.fiuba.algo3.componentes.bindings.ConstructorLazyConVisible;
import edu.fiuba.algo3.componentes.bindings.Point2DBindingXY;
import edu.fiuba.algo3.componentes.bindings.SimplePoint2DBinding;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.controlador.Radio.RadioControlador;
import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Juego.IObservadorAcciones;
import edu.fiuba.algo3.modelo.Juego.Radio.Radio;
import edu.fiuba.algo3.vista.Calendario.Reloj;
import edu.fiuba.algo3.vista.Radio.Walkman;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

public class Pantalla extends RelativoAImagen {
    private Walkman walkman = null;
    private BooleanProperty tarjetasVisible = new SimpleBooleanProperty(false);
    private ObjectProperty<Tarjetas> tarjetas = new SimpleObjectProperty<>(null);
    private BooleanProperty relojVisible = new SimpleBooleanProperty(false);
    private ObjectProperty<Reloj> reloj = new SimpleObjectProperty<Reloj>(null);
    private ObjectProperty<Calendario> calendario = new SimpleObjectProperty<>(null);
    private SimplePoint2DBinding relojCoordenadas = new SimplePoint2DBinding(0.08, 0.9);
    private DoubleProperty escalaReloj = new SimpleDoubleProperty(0.85);
    private ObjectProperty<IObservadorAcciones> observadorAcciones = new SimpleObjectProperty<>(null);

    public Pantalla(Image imagen) {
        super(imagen);
        inicializar();
    }

    public Pantalla(String path) {
        super(path);
        inicializar();
    }

    protected void iniciarControlador(PantallaControlador controlador) {
        controlador.agregarLiberador(this);
    }

    private void inicializar() {
        tarjetas.bind(new ConstructorLazyConVisible<Tarjetas>(this::crearTarjetas, tarjetasVisible));
        reloj.bind(new ConstructorLazyConVisible<Reloj>(this::crearReloj, relojVisible));

        calendario.addListener(this::alCambiarCalendario);
        observadorAcciones.addListener(this::cambiarObservadorAcciones);
    }

    private void cambiarObservadorAcciones(ObservableValue<? extends IObservadorAcciones> obs,
                                           IObservadorAcciones obsViejo, IObservadorAcciones obsNuevo) {
        Calendario cal = calendario.get();
        if(null != cal) {
            if(null != obsViejo) {
                cal.desobservarAcciones(obsViejo);
            }
            if(null != obsNuevo) {
                cal.observarAcciones(obsNuevo);
            }
        }
    }

    private void alCambiarCalendario(ObservableValue<? extends Calendario> obs, Calendario viejo, Calendario nuevo) {
        IObservadorAcciones observador = observadorAcciones.get();
        if(null == observador) {
            return;
        }
        if(null != viejo) {
            nuevo.desobservarAcciones(observador);
        } else if (null != nuevo) {
            nuevo.observarAcciones(observador);
        }
    }

    public IObservadorAcciones getObservadorAcciones() {
        return observadorAcciones.get();
    }

    public ObjectProperty<IObservadorAcciones> observadorAccionesProperty() {
        return observadorAcciones;
    }

    public void setObservadorAcciones(IObservadorAcciones observadorAcciones) {
        this.observadorAcciones.set(observadorAcciones);
    }

    /*********************************************************/
    /*** CREACIÓN DE CONTROLES REUSABLES                   ***/
    /*********************************************************/

    private Reloj crearReloj() {
        Reloj instancia = new Reloj(calendario);
        instancia.scaleXProperty().bind(escalaReloj);
        instancia.scaleYProperty().bind(escalaReloj);
        super.agregar(instancia, relojCoordenadas);
        return instancia;
    }

    private Tarjetas crearTarjetas() {
        Tarjetas instancia = new Tarjetas(640);
        agregar(instancia, 0.9, 0.9);
        return instancia;
    }

    /*********************************************************/
    /*** GETTERS DE CONTROLES REUSABLES Y SUS PROPIEDADES  ***/
    /*********************************************************/

    public Reloj getReloj() {
        return reloj.get();
    }

    public Point2D getRelojCoordenadas() {
        return relojCoordenadas.get();
    }

    public boolean isRelojVisible() {
        return relojVisible.get();
    }

    public ObjectProperty<Reloj> relojProperty() {
        return reloj;
    }

    public Point2DBindingXY relojCoordenadasProperty() {
        return relojCoordenadas;
    }

    public BooleanProperty relojVisibleProperty() {
        return relojVisible;
    }

    /**
     * Devuelve el control de tarjetas.
     * @return La instancia o null si no hay.
     */
    protected Tarjetas getTarjetas()
    {
        return tarjetas.get();
    }

    public boolean isTarjetasVisible() {
        return tarjetasVisible.get();
    }

    public ObjectProperty<Tarjetas> tarjetasProperty() {
        return tarjetas;
    }

    public BooleanProperty tarjetasVisibleProperty() {
        return tarjetasVisible;
    }

    /**
     * Devuelve el control de walkman.
      * @return La instancia o null si no hay.
     */
    protected Walkman getWalkman() {
        return walkman;
    }

    /*********************************************************/
    /*** SETTERS DE CONTROLES REUSABLES                    ***/
    /*********************************************************/

    public void setCalendario(Calendario calendario) {
        this.calendario.set(calendario);
    }

    public void setRelojCoordenadas(Point2D relojCoordenadas) {
        this.relojCoordenadas.set(relojCoordenadas);
    }

    public void setRelojVisible(boolean relojVisible) {
        this.relojVisible.set(relojVisible);
    }


    public void setTarjetasVisible(boolean tarjetasVisible) {
        this.tarjetasVisible.set(tarjetasVisible);
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

    /**
     * Obtiene el título de la pantalla.
     * @return Un texto válido de la pantalla, o null si no fue definido.
     */
    public String getTitulo() {
        return null;
    }


    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
