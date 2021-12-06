package edu.fiuba.algo3.modelo.Item;

public class Item {

    private final String nombreDelItem;
    private final String nombreCiudadDelRobo;

    public Item(String nombreDelItem, String nombreCiudadDelRobo){

        this.nombreDelItem = nombreDelItem;
        this.nombreCiudadDelRobo = nombreCiudadDelRobo;
    }

    public boolean estaElItem(String nombreItem) {
        return this.nombreDelItem.equals(nombreItem);
    }

    public String getNombre() {
        return nombreDelItem;
    }

    public String getNombreCiudadDelRobo() {
        return nombreCiudadDelRobo;
    }
}
