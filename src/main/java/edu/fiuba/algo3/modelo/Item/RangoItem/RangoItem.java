package edu.fiuba.algo3.modelo.Item.RangoItem;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Ciudad.Mapa;

import java.util.List;
import java.util.Random;

public abstract class RangoItem {

    public void ampliarRuta(List<Ciudad> ruta, Mapa mapa, Random random) {
        while(debeAmpliar(ruta)) {
            mapa.agregarSiguiente(ruta,random);
        }
    }

    protected abstract boolean debeAmpliar(List<? extends Object> ruta);

}
