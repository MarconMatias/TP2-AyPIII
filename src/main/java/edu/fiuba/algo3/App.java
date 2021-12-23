package edu.fiuba.algo3;

import edu.fiuba.algo3.componentes.FakeLoader.FakeService;
import edu.fiuba.algo3.componentes.Radio.RadioSonido;
import edu.fiuba.algo3.componentes.bindings.CargandoBinding;
import edu.fiuba.algo3.controlador.Policia.PoliciaControlador;
import edu.fiuba.algo3.controlador.Splash.SplashControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Policias;
import edu.fiuba.algo3.vista.Splash;
import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    Juego juego = new Juego();
    Stage stage;
    RadioSonido radio;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.radio = new RadioSonido(juego.getRadio());
        startSplash(stage);
    }

    ControlStage controlador;

    private void startSplash(Stage stage) {
        FakeService lector = new FakeService(5);
        CargandoBinding tituloBinding = new CargandoBinding(lector.progressProperty(),
                "AlgoThief — ¡Listo!",
                "AlgoThief — Cargando… %.2f%%");
        stage.titleProperty().bind(tituloBinding);

        SplashControlador splashControlador = new SplashControlador(juego);
        Splash splash = new Splash(juego, splashControlador);
        controlador = new ControlStage(stage, splash);
        splash.requestFocus();
        splash.setFocusTraversable(false);
        //root.setFocusTraversable(false);
        //Rectangle2D scr = controlador.getDimensionPantalla();
        controlador.start();
        stage.sizeToScene();
        stage.centerOnScreen();
        splash.progresoProperty().bind(lector.progressProperty());
        lector.start();
        stage.show();
        lector.setOnSucceeded(ev -> {
            stage.titleProperty().unbind();
            splashControlador.enlazarIniciar(this::mostrarPolicias);
            splash.requestFocus();
        });
        lector.setOnFailed(this::onSplashFailed);
    }

    private void onSplashExitoso(SplashControlador splashControlador) {

    }

    private void onSplashFailed(WorkerStateEvent workerStateEvent) {
        /** \todo Mínimo, mostrar un mensaje de error. **/
        /** \todo Mejorar: reintentar (vuelve a llamar a startSplash). **/
    }

    private void mostrarPolicias(Event event) {
        PoliciaControlador policiaControlador = new PoliciaControlador(juego, controlador);
        Group principal = new Policias(juego, policiaControlador);
        controlador.cambiar(principal);
        controlador.start();
        stage.setTitle("AlgoThief — Elija el agente para iniciar una misión");
        stage.sizeToScene();
        stage.centerOnScreen();
    }
    public static void main(String[] args) {
        launch();
    }

}