package edu.fiuba.algo3.componentes.bindings;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;

public class CargandoBinding extends StringBinding {
    private final ReadOnlyDoubleProperty progreso;
    private final String textoFinal;
    private final String formato;

    public CargandoBinding(ReadOnlyDoubleProperty progreso, String textoFinal, String formato) {
        super.bind(progreso);
        this.progreso = progreso;
        this.textoFinal = textoFinal;
        this.formato = formato;
    }
    public CargandoBinding(DoubleProperty progreso, String textoFinal) {
        this(progreso, textoFinal, "Cargando… %.1f%%");
    }
    public CargandoBinding(DoubleProperty progreso) {
        this(progreso, "¡Listo!");
    }
    @Override
    protected String computeValue() {
        double valor = progreso.get();
        if(progreso.get()<1.0) {
            valor = Math.max(0, valor);
            valor = Math.floor(valor*1e3)/10;
            return String.format(formato, valor);
        }
        return textoFinal;
    }
}
