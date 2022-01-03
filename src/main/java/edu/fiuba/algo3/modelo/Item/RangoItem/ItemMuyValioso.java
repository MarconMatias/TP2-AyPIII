package edu.fiuba.algo3.modelo.Item.RangoItem;

import java.util.List;

public class ItemMuyValioso extends RangoItem {

    @Override
    protected boolean debeAmpliar(List<?> ruta) {
        return ruta.size()<7;
    }
}
