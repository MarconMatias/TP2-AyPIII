package edu.fiuba.algo3;

import edu.fiuba.algo3.componentes.Cargador.CargarVistaServicio;
import edu.fiuba.algo3.componentes.Radio.RadioSonido;
import edu.fiuba.algo3.componentes.Binding.CargandoBinding;
import edu.fiuba.algo3.controlador.ControlStage;
import edu.fiuba.algo3.controlador.Juego.Splash.SplashControlador;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.vista.Juego.Splash;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    Juego juego = new Juego();
    Stage stage;
    RadioSonido radio;
    private Splash splash;
    ControlStage controlador;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        try {
            this.radio = new RadioSonido(juego.getRadio());
        } catch(Exception ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR, "No pudo reproducirse el sonido: "+ex, ButtonType.OK);
            alerta.showAndWait();
        }
        startSplash(stage);
    }


    private void startSplash(Stage stage) {
        CargarVistaServicio lector = new CargarVistaServicio(5);
        CargandoBinding tituloBinding = new CargandoBinding(lector.progressProperty(),
                "AlgoThief — ¡Listo!",
                "AlgoThief — Cargando… %.2f%%");
        stage.titleProperty().bind(tituloBinding);

        SplashControlador splashControlador = new SplashControlador(juego);
        splash = new Splash(juego, splashControlador);
        controlador = new ControlStage(stage, juego, splash);
        splash.requestFocus();
        splash.setFocusTraversable(false);
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
        lector.setOnFailed(ev -> {
            Throwable ex = lector.getException();
            Alert alerta = new Alert(Alert.AlertType.ERROR, "Se produjo un error al iniciar: "+ex, ButtonType.OK);
            alerta.showAndWait();
        });
    }

    private void mostrarPolicias(Event event) {
        if(controlador.abrirMenu()) {
            controlador.sacar(splash);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}