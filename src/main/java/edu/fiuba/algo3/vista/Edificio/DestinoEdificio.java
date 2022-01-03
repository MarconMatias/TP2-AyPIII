package edu.fiuba.algo3.vista.Edificio;

import edu.fiuba.algo3.componentes.Imagen.Destino;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class DestinoEdificio extends Destino {

    private final Edificio edificio;

    public DestinoEdificio(Image imageSel, Image imageDesel, Edificio edificio) {
        super(imageSel, imageDesel, edificio.getNombre());
        this.edificio = edificio;
    }

    protected DestinoEdificio(Edificio edificio) {
        this(getImageSel(), getImageDesel(), edificio);
    }

    public static DestinoEdificio crear(Edificio edificio) {
        switch (edificio.getNombre()) {
            case "Aeropuerto":
                return new Aeropuerto(edificio);
            case "Banco":
                return new Banco(edificio);
            case "Biblioteca":
                return new Biblioteca(edificio);
            case "Bolsa":
                return new Bolsa(edificio);
            case "Puerto":
                return new Puerto(edificio);
        }
        //System.out.println("Advertencia: "+edificio.getNombre()+" no puede construirse.");
        return new DestinoEdificio(edificio);
    }

    public Point2D getCoordenadas() {
        return new Point2D(0.5,0.5);
    }


    public Edificio getEdificio() {
        return edificio;
    }

    /**
     * Posición para ser usada en una lista de posibles coordenadas. Depende de la instancia de edificio.
     *
     * @param cantidad Cantidad (mayor a 0) de posibles coordenadas.
     * @return Devuelve un número entre 0 y cantidad-1.
     */
    protected int getIndice(int cantidad) {
        return edificio.hashCode() % cantidad;
    }

    public static void precargar() {
        /** No necesita cuerpo. La sola invocación de este método precargará los static. **/
    }
}
