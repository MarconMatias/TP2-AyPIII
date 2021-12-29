package edu.fiuba.algo3.vista.Accion;

import edu.fiuba.algo3.componentes.Imagen.Imagen;
import edu.fiuba.algo3.controlador.Accion.PantallaAccionControlador;
import edu.fiuba.algo3.controlador.Juego.PantallaControlador;
import edu.fiuba.algo3.modelo.Acciones.*;
import edu.fiuba.algo3.modelo.Juego.Juego;
import edu.fiuba.algo3.modelo.Juego.Mision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
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
