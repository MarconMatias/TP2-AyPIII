package edu.fiuba.algo3.componentes.Binding;

import edu.fiuba.algo3.vista.Ciudad.DestinoCiudad;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.ObjectExpression;

public class AnguloDeDestinoBinding extends DoubleBinding {
    private final ObjectExpression<DestinoCiudad> destino;
    private final DoubleExpression progreso;
    private double ultimo = 0d;

    public AnguloDeDestinoBinding(ObjectExpression<DestinoCiudad> destino, DoubleExpression progreso) {
        this.bind(destino, progreso);
        this.destino = destino;
        this.progreso = progreso;
    }

    public AnguloDeDestinoBinding(ObjectExpression<DestinoCiudad> destino, DoubleExpression progreso, double inicial) {
        this(destino, progreso);
        ultimo = inicial;
    }

    @Override
    protected double computeValue() {
        DestinoCiudad valorDestino = destino.get();
        if(null == valorDestino) {
            return ultimo;
        }
        double nuevo = valorDestino.anguloParaProgreso(progreso.get());
        if(!Double.isFinite(nuevo)) {
            return ultimo;
        }
        return ultimo = nuevo;
    }
}
