package edu.fiuba.algo3.modelo.Ladron;

import javafx.collections.ObservableMap;

public interface DetallableSospechoso {
    public ObservableMap<String, String> getDetallesDeSospechoso();
    public String getDetalle(String tipo);
}
