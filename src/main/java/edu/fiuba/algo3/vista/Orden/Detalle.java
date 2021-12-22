package edu.fiuba.algo3.vista.Orden;

import edu.fiuba.algo3.controlador.Orden.DetalleControlador;
import edu.fiuba.algo3.modelo.Computadora.Evento.ComputadoraEvento;
import edu.fiuba.algo3.modelo.Computadora.Evento.ComputadoraListener;
import edu.fiuba.algo3.modelo.Computadora.Evento.DetalleModificadoEvento;
import edu.fiuba.algo3.modelo.Juego.Mision;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.Map;
import java.util.function.UnaryOperator;

public class Detalle extends HBox implements ComputadoraListener {
    private final static Map<String, String> textosTipos = Map.of("vehiculo", "Vehículo");
    private final static Map<String, String> textosValores = Map.of("Macho", "Masculino", "Hembra", "Femenino");
    private final String tipo;
    private final Mision mision;
    private final Label valor;
    private final UnaryOperator<String> valorATexto;

    public Detalle(String tipo, Mision mision, UnaryOperator<String> tipoATexto, UnaryOperator<String> valorATexto, DetalleControlador controlador) {
        this.tipo = tipo;
        this.mision = mision;
        this.valorATexto = valorATexto;

        mision.oirOrden(this);

        getStyleClass().add("vistaDetalle");
        setFocusTraversable(true);

        Label titulo = new Label(tipoATexto.apply(tipo) + ":");
        titulo.setAlignment(Pos.TOP_LEFT);
        titulo.setMinWidth(480);
        titulo.setMaxWidth(480);
        titulo.setStyle("-fx-font: 60 Arial");
        titulo.getStyleClass().add("tipoDetalle");
        setHgrow(titulo, Priority.ALWAYS);

        valor = new Label("?");
        valor.setAlignment(Pos.TOP_LEFT);
        valor.setMinWidth(480);
        valor.setMaxWidth(480);
        valor.setStyle("-fx-font: 60 \"Times New Roman\"");
        valor.getStyleClass().add("valorDetalle");
        setHgrow(valor, Priority.ALWAYS);

        setSpacing(10);
        setMinWidth(480 * 2 + 10);

        if(null != controlador) {
            setOnKeyPressed(controlador::onKeyPressed);
            setOnMouseClicked(controlador::onMouseClicked);
        }
        actualizar();
        this.getChildren().setAll(titulo, valor);
        this.setFocusTraversable(true);
    }

    public Detalle(String tipo, Mision mision,
                   Map<String, String> mapaTipos,
                   Map<String, String> mapaValores,
                   DetalleControlador controlador) {
        this(tipo, mision, textoDeMapODesconocido(mapaTipos), textoDeMapODesconocido(mapaValores), controlador);
    }

    public Detalle(String tipo, Mision mision, DetalleControlador controlador) {
        this(tipo, mision, textosTipos, textosValores, controlador);
    }

    /**
     * Crea un operador que convierte un texto en otro con base en map indicado, pero si es
     * null o vacío devuelve el texto "Desconocido".
     * @param map Un map texto de entrada -> texto de salida.
     * @return Un operador que convierte un string en otro.
     */
    public static UnaryOperator<String> textoDeMapODesconocido(Map<String, String> map) {
        return entrada -> {
            if ((null == entrada) || (entrada.trim().equals(""))) {
                return "Desconocido";
            }
            String texto = map.get(entrada);
            return (null == texto) ? entrada : texto;
        };
    }

    @Override
    public void handle(ComputadoraEvento eventoGenerico) {
        if(!(eventoGenerico instanceof DetalleModificadoEvento)) {
            return;
        }
        DetalleModificadoEvento evento = ((DetalleModificadoEvento) eventoGenerico);
        if(!evento.esTipo(tipo)) {
            return;
        }
        actualizar();
    }

    private void actualizar() {
        valor.setText(valorATexto.apply(mision.getDetalle(tipo)));
    }
}
