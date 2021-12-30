package edu.fiuba.algo3.vista.Accion;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.controlador.Accion.PantallaAccionControlador;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Acciones.*;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.util.Map;

public class PantallaAccion extends Pantalla {
    private final static Image fondo = new Image(Imagen.urlDesdeRecursos("Accion/accion.jpeg"));
    private final static Map<Class<? extends IAccion>, Image> fondos = Map.of(
            HeridaPorCuchillo.class, new Image(Imagen.urlDesdeRecursos("Accion/cuchillo.jpeg")),
            HeridaPorDisparo.class, new Image(Imagen.urlDesdeRecursos("Accion/disparo.jpeg")),
            AccionDormir.class, new Image(Imagen.urlDesdeRecursos("Accion/dormir.jpeg")),
            EmitirOrden.class, new Image(Imagen.urlDesdeRecursos("Accion/orden.jpeg"))
    );
    private final IAccion accion;

    public PantallaAccion(Juego juego, Mision mision, IAccion accion, PantallaAccionControlador controlador) {
        super(fondoDeAccion(accion));
        this.accion = accion;

        Label etiquetaNombre = new Label(accion.getTextoAccion());
        etiquetaNombre.prefWidthProperty().bind(nuevoXRelativo(0.9));
        etiquetaNombre.setAlignment(Pos.CENTER);
        etiquetaNombre.setStyle("-fx-font: 120 Arial");
        etiquetaNombre.getStyleClass().add("etiquetaNombreAccion");
        agregar(etiquetaNombre, 0.5, 0.1);

        Label textoContinuar = new Label("Hacé click o presioná una tecla para continuar…");
        textoContinuar.prefWidthProperty().bind(nuevoXRelativo(0.9));
        textoContinuar.setAlignment(Pos.CENTER);
        textoContinuar.setStyle("-fx-font: 100 Arial");
        textoContinuar.getStyleClass().add("textoContinuarAccion");
        agregar(textoContinuar, 0.5, 0.9);

        this.setFocusTraversable(true);
        setCalendario(mision.getCalendario());
        iniciarControlador(controlador);
    }

    @Override
    protected void iniciarControlador(PantallaControlador controlador) {
        super.iniciarControlador(controlador);
        setRelojVisible(true);
        setOnMouseClicked(controlador::fondoClicked);
        setOnKeyPressed(controlador::fondoKeyPressed);
    }

    private static Image fondoDeAccion(IAccion accion) {
        Class<? extends IAccion> clase = accion.getClass();
        return fondos.getOrDefault(clase, fondo);
    }

    @Override
    public String getTitulo() {
        return accion.getNombreAccion();
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
