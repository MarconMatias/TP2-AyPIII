package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Mision {
    private final Ladron ladronDeLaMision;
    private final Policia policiaDeLaMision;
    private final Item itemDeLaMision;
    private final Ciudad ciudadDePartidaDeLaMision;
    // Ladron
  // Policia
  // Item
    //Yo Agus le agregaria una referencia a una ciudad actual que en el constructor corresponderia a la
    //ciudad sobre la cual se parte
    //El mapa seria un grafo donde cada nodo es una ciudad y cuando se viaja de una ciudad a otra
    //solo se puede hacerlo desde la ciudad actual hacia sus vecinas

    public Mision(Ladron unLadron, Policia unPolicia, Item unItem, Ciudad ciudadDeInicio){

        ladronDeLaMision = unLadron;
        policiaDeLaMision = unPolicia;
        itemDeLaMision = unItem;
        ciudadDePartidaDeLaMision = ciudadDeInicio;
    }


    public Ciudad viajarACiudad(Ciudad ciudadActual, String nombreDeLaCiudadDestino) {

        Ciudad ciudadAViajar = ciudadActual.getCiudadVecina(nombreDeLaCiudadDestino);
        return ciudadAViajar;
    }
}
