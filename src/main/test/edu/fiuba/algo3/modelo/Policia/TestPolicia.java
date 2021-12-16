package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Juego.Calendario;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestPolicia {

    @Test
    public void policiaNovatoViaja1800KmsYTarda2Horas(){

        Policia policia = new Policia("Agus",0, new Calendario());
        Assert.assertTrue(policia.viajar(1800) == 2);
    }


}
