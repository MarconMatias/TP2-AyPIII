package edu.fiuba.algo3;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.controlador.Accion.PantallaAccionControlador;
import edu.fiuba.algo3.controlador.Ciudad.LibroCiudadControlador;
import edu.fiuba.algo3.controlador.Edificio.EdificiosControlador;
import edu.fiuba.algo3.controlador.Edificio.Testigo.TestigoControlador;
import edu.fiuba.algo3.controlador.Juego.AcercaDeControlador;
import edu.fiuba.algo3.controlador.Mapa.MapaDestinosControlador;
import edu.fiuba.algo3.controlador.Orden.ExpedienteControlador;
import edu.fiuba.algo3.controlador.Orden.OrdenControlador;
import edu.fiuba.algo3.controlador.Policia.PoliciaControlador;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.vista.Accion.PantallaAccion;
import edu.fiuba.algo3.vista.Ciudad.LibroCiudad;
import edu.fiuba.algo3.vista.Edificio.Edificios;
import edu.fiuba.algo3.vista.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.vista.Juego.AcercaDe;
import edu.fiuba.algo3.vista.Juego.GrupoInterno;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import edu.fiuba.algo3.vista.Mapa.MapaDestinos;
import edu.fiuba.algo3.vista.Orden.Expediente;
import edu.fiuba.algo3.vista.Orden.Orden;
import edu.fiuba.algo3.vista.Policia.Policias;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.List;

public class ControlStage {
    private final static String tituloApp = "AlgoThief";
    private final Stage stage;
    private final GrupoInterno raiz;
    private final Scene scene;
    private final Scale escalado = new Scale();
    private final DoubleProperty escala = new SimpleDoubleProperty(1.0);
    private final Juego juego;
    private Mision mision;

    public ControlStage(Stage stage, Juego juego, Pantalla interno) {
        this.stage = stage;
        this.juego = juego;
        this.raiz = new GrupoInterno(interno);
        this.scene = new Scene(raiz);
        final String pathEstilo = "src/main/java/edu/fiuba/algo3/recursos/estilos.css";
        final String url = Imagen.urlDesdePath(pathEstilo);
        scene.getStylesheets().addAll(url);
        escalado.setPivotX(0d);
        escalado.setPivotY(0d);
        escalado.xProperty().bind(escala);
        escalado.yProperty().bind(escala);
        raiz.getTransforms().setAll(escalado);
        escala.bind(new DoubleBinding() {
            {
                this.bind(stage.widthProperty(), raiz.boundsInLocalProperty());
            }
            @Override
            protected double computeValue() {
                return stage.getWidth()/raiz.getBoundsInLocal().getWidth();
            }
        });
    }

    /**************************************************************************/
    /**************************************************************************/

    public boolean abrirAcercaDe(Juego juego, Mision mision, AcercaDeControlador controlador) {
        try {
            AcercaDe nuevaVista = new AcercaDe(juego, mision, controlador);
            ponerSiguiente(nuevaVista);
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir la ayuda: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

    public boolean abrirAcercaDe(Juego juego, Mision mision) {
        return abrirAcercaDe(juego, mision, new AcercaDeControlador(juego, mision, this));
    }
    /**************************************************************************/

    public boolean abrirOrden(Juego juego, Mision mision, OrdenControlador controlador) {
        try {
            Orden nuevaVista = new Orden(juego, mision, controlador);
            ponerSiguiente(nuevaVista);
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir la orden: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }
    public boolean abrirOrden(Juego juego, Mision mision) {
        return abrirOrden(juego,mision,new OrdenControlador(juego, mision, this));
    }

    /**************************************************************************/

    public boolean abrirEdificios(Juego juego, Mision mision, EdificiosControlador controlador) {
        try {
            Edificios nuevaVista = new Edificios(juego, mision, controlador);
            ponerSiguiente(nuevaVista);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir plano de la ciudad: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

    public boolean abrirEdificios(Juego juego, Mision mision) {
        return abrirEdificios(juego, mision, new EdificiosControlador(juego, mision, this));
    }

    /**************************************************************************/

    private boolean abrirExpediente(Juego juego, Mision mision, Ladron ladron, ExpedienteControlador controlador) {
        try {
            Expediente nuevaVista = new Expediente(juego, mision, ladron, controlador);
            ponerSiguiente(nuevaVista);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir expediente: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

    public boolean abrirExpediente(Juego juego, Mision mision, Ladron ladron) {
        return abrirExpediente(juego, mision, ladron, new ExpedienteControlador(juego, mision, this));
    }

    /**************************************************************************/

    public boolean abrirLibroCiudad(Juego juego, Mision mision, LibroCiudadControlador controlador) {
        try {
            LibroCiudad libro = new LibroCiudad(juego, mision, controlador);
            ponerSiguiente(libro);
            return true;
        } catch(Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir libro: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

    public boolean abrirLibroCiudad(Juego juego, Mision mision) {
        return abrirLibroCiudad(juego, mision, new LibroCiudadControlador(juego, mision, this));
    }

    /**************************************************************************/

    public boolean abrirMapaCiudades(Juego juego, Mision mision, MapaDestinosControlador controlador) {
        try {
            MapaDestinos nuevaVista = new MapaDestinos(juego, mision, controlador);
            ponerSiguiente(nuevaVista);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir mapamundi: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }
    public boolean abrirMapaCiudades(Juego juego, Mision mision) {
        MapaDestinosControlador controlador = new MapaDestinosControlador(juego, mision, this);
        return abrirMapaCiudades(juego, mision, controlador);
    }

    /**************************************************************************/

    public boolean abrirMisionNueva(Juego juego, Policia policia, LibroCiudadControlador controlador) {
        try {
            Mision mision = juego.nuevaMision(policia);
            if(null==controlador) {
                return abrirLibroCiudad(juego, mision);
            } else {
                return abrirLibroCiudad(juego, mision, controlador);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "No pudo crearse la misión: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

    public boolean abrirMisionNueva(Juego juego, Policia policia) {
        return abrirMisionNueva(juego, policia, null);
    }

    /**************************************************************************/

    public boolean abrirMenu() {
        try {
            PoliciaControlador controlador = new PoliciaControlador(juego, this);
            Pantalla nuevaVista = new Policias(juego, controlador);
            ponerSiguiente(nuevaVista);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir pantalla principal: " + ex, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }

    /**************************************************************************/
    public void abrirDerrota(Juego juego, Mision mision) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mision.getMensajeMision(), ButtonType.OK);
        alert.showAndWait();
        this.mision = null;
        abrirMenu();
    }
    public void abrirVictoria(Juego juego, Mision mision) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mision.getMensajeMision(), ButtonType.OK);
        alert.showAndWait();
        this.mision = null;
        abrirMenu();
    }

    /**************************************************************************/
    public boolean abrirTestigo(Juego juego, Mision mision,
                             String testigo, String testimonio,
                             TestigoControlador controlador) {
        try {
            Pantalla nuevaVista = new Testigo(juego, mision, testigo, testimonio, controlador);
            ponerSiguiente(nuevaVista);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al abrir testimonio: " + ex, ButtonType.OK);
            alert.showAndWait();
            alert = new Alert(Alert.AlertType.INFORMATION, testigo + " dice:\n"+testimonio, ButtonType.OK);
            alert.showAndWait();
            return false;
        }
    }
    public boolean abrirTestigo(Juego juego, Mision mision, String testigo, String testimonio) {
        return abrirTestigo(juego,mision,testigo,testimonio,
                new TestigoControlador(juego, mision, this));
    }
    /**************************************************************************/
    public void mostrarAccion(Juego juego, Mision mision, IAccion accion, PantallaAccionControlador controlador) {
        try {
            Pantalla pantalla = new PantallaAccion(juego, mision, accion, controlador);
            raiz.ponerArriba(pantalla);
            setTituloPantalla(pantalla.getTitulo());
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al accion: " + ex, ButtonType.OK);
            alert.showAndWait();
            alert = new Alert(Alert.AlertType.INFORMATION, accion.getNombreAccion(), ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void setTituloPantalla(String titulo) {
        stage.setTitle( (null==titulo) ? tituloApp : tituloApp + " — " + titulo );
    }

    public void mostrarAccion(Juego juego, Mision mision, IAccion accion) {
        mostrarAccion(juego,mision,accion,new PantallaAccionControlador(juego,mision,this));
    }
    /**************************************************************************/
    /**************************************************************************/

    public Point2D getCentro() {
        double x = stage.getX() + (stage.getWidth()/2);
        double y = stage.getY() + (stage.getHeight()/2);
        if(Double.isNaN(Math.max(x,y))) {
            return getCentroPantalla();
        }
        return new Point2D(x,y);
    }

    public static Point2D getCentro(Rectangle2D rect) {
        double x = (rect.getMinX() + rect.getMaxX()) / 2;
        double y = (rect.getMinY() + rect.getMaxY()) / 2;
        return new Point2D(Math.max(0,x),Math.max(0,y));
    }

    public Point2D getCentroPantalla() {
        return getCentro(getDimensionPantalla());
    }

    private static double siNaNEntonces(double talVezNaN, double reemplazo) {
        return Double.isNaN(talVezNaN) ? reemplazo : talVezNaN;
    }

    public Rectangle2D getDimensionPantalla() {
        List<Screen> screens = Screen.getScreensForRectangle(stage.getX(), stage.getY(),1, 1);
        // Si no está inicializado el stage, getX() y getY() devuelven NaN y la lista estará vacía:
        Screen screen = (screens.size()>0) ? screens.get(0) : Screen.getPrimary();
        return screen.getBounds();
    }

    public void setCentro(Point2D nuevoCentro) {
        double ancho = siNaNEntonces(stage.getWidth(), 0);
        double alto =  siNaNEntonces(stage.getHeight(), 0);
        double x = nuevoCentro.getX()-(ancho/2);
        double y = nuevoCentro.getY()-(alto/2);
        stage.setX(x);
        stage.setY(y);
    }

    public void start() {
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
        setCentro(getCentroPantalla());
        stage.setResizable(false);
    }

    public Scene getScene() {
        return scene;
    }

    /**
     * Agrega una pantalla a ser vista luego de que se cierren las actuales.
     * @param siguiente Pantalla nueva a agregar.
     * @return
     */
    private boolean ponerSiguiente(Pantalla siguiente) {
        return ponerAbajo(siguiente, null);
    }

    /**
     * Agrega una pantalla abajo de la referencia.
     * @param nueva Pantalla a agregar.
     * @param referencia Pantalla que queda encima de la nueva.
     * @return
     */
    private boolean ponerAbajo(Pantalla nueva, Pantalla referencia) {
        Pantalla actual = raiz.ponerAbajo(nueva, referencia);
        if(null != actual) {
            actualizar();
        }
        return null != actual;
    }

    /**
     * Sacá la pantalla actual, es decir la que está arriba.
     * @return Si había una pantalla efectivamente.
     */
    public boolean sacarPantallaActual() {
        Pantalla anterior = raiz.sacarActual();
        if(null != anterior) {
            actualizar();
        }
        return null != anterior;
    }

    /**
     * Saca una pantalla, independientemente de la posición, si es que existe.
     * @param pantalla Pantalla a remover.
     */
    public void sacar(Pantalla pantalla) {
        if(raiz.sacar(pantalla)) {
            actualizar();
        };
    }

    private void actualizar() {
        Pantalla actual = raiz.getActual();
        if(null == actual) {
            return;
        }
        setTituloPantalla(actual.getTitulo());
    }
}
