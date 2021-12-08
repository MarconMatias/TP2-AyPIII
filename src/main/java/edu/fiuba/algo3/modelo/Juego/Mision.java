package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Ciudad.CiudadVisitada;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Mision {
    private final Ladron ladronDeLaMision;
    private final Policia policiaDeLaMision;
    private final String ciudadActual;
    private final Item itemDelJuego;
    private final Calendario calendario;
    private Mapa mapa;
    // Ladron
  // Policia
  // Item
    //Yo Agus le agregaria una referencia a una ciudad actual que en el constructor corresponderia a la
    //ciudad sobre la cual se parte
    //El mapa seria un grafo donde cada nodo es una ciudad y cuando se viaja de una ciudad a otra
    //solo se puede hacerlo desde la ciudad actual hacia sus vecinas

    public Mision(Ladron unLadron, Policia unPolicia, Item unItem, Mapa unMapa, Calendario unCalendario){

        ladronDeLaMision = unLadron;
        policiaDeLaMision = unPolicia;
        itemDelJuego = unItem;
        ciudadActual = unItem.getNombreCiudadDelRobo();
        calendario = unCalendario;
    }

    public Mision(Policia unPolicia) {

        ladronDeLaMision = null;
        policiaDeLaMision = null;
        itemDelJuego = null;
        ciudadActual = null;
        calendario = null;
    }


    public CiudadVisitada viajarACiudad(Ciudad ciudadActual, String nombreDeLaCiudadDestino) {

        CiudadVisitada unaCiudad = mapa.viajarHacia(policiaDeLaMision,calendario,nombreDeLaCiudadDestino);
        return unaCiudad;
    }

    public boolean arrestar() {
        return false;
    }
}
