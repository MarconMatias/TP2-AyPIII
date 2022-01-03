package edu.fiuba.algo3.componentes.Cargador;

import edu.fiuba.algo3.componentes.Cuaderno.Cuaderno;
import edu.fiuba.algo3.componentes.Imagen.*;
import edu.fiuba.algo3.componentes.Libro.Libro;
import edu.fiuba.algo3.vista.Calendario.Accion.PantallaAccion;
import edu.fiuba.algo3.vista.Calendario.Reloj;
import edu.fiuba.algo3.vista.Ciudad.FotoCiudad;
import edu.fiuba.algo3.vista.Ciudad.LibroCiudad;
import edu.fiuba.algo3.vista.Edificio.*;
import edu.fiuba.algo3.vista.Juego.Final.Derrota;
import edu.fiuba.algo3.vista.Juego.Final.Victoria;
import edu.fiuba.algo3.vista.Juego.HojaMision;
import edu.fiuba.algo3.vista.Juego.Pantalla;
import edu.fiuba.algo3.vista.Computadora.Documentos;
import edu.fiuba.algo3.vista.Computadora.IconoOrden;
import edu.fiuba.algo3.vista.Policia.Policias;
import edu.fiuba.algo3.vista.Juego.Radio.Walkman;
import javafx.concurrent.Task;

import java.lang.reflect.Method;
import java.util.List;

public class CargarVistasTarea extends Task<Void> {
    private final double factor;

    public CargarVistasTarea(double factor) {
        this.factor = factor;
    }

    @Override
    protected Void call() throws Exception {
        List<Class<? extends Object>> vistas = List.of(
                Walkman.class, Tarjetas.class, Reloj.class,
                Destino.class, FotoCiudad.class,
                Pantalla.class, Cuaderno.class, Libro.class, Documentos.class,
                LibroCiudad.class, Victoria.class, Derrota.class,
                IconoEdificios.class, IconoVolver.class, IconoOrden.class,
                Mapita.class,
                Edificios.class, DestinoEdificio.class, Aeropuerto.class,
                Banco.class, Biblioteca.class, Bolsa.class, Puerto.class,
                PantallaAccion.class, HojaMision.class, Policias.class);
        int progreso = 0;
        int maximo = 10*vistas.size();

        for(Class<? extends Object> clase : vistas) {
            try {
                Method precargar = clase.getMethod("precargar");
                precargar.invoke(null);
            } catch (Exception ex) {
                //System.err.println("Error al precargar "+clase.getName());
                ex.printStackTrace();
            }
            progreso+=10;
            updateProgress(progreso,maximo);
        }

        this.done();
        return null;
    }
}
