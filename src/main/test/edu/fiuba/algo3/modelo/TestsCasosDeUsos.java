package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Banco;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

public class TestsCasosDeUsos {

    //Casos de usos
    @Test

    public void test01CasoDeUso1ElLadronRobaUnTesoroNacionalDeMontrealSospechosoFemeninoYDetectiveNovatoEncuentraPistaEnUnBanco() throws IOException {

        boolean policiaEntro = false;
        Policia nuevoPolicia = new Policia((new RangoPolicia()),"Agus");
        Ladron unLadron = new Ladron("Ada","Femenino","Jockey sobre Hielo","Rubio","anillo de oro","Moto");
        Banco banco = new Banco("Banco de Montreal"); //En vez de usar un campo true podria settearse con Strategy el comportamiento de un Edificio para que muestre una pista o no
        policiaEntro = nuevoPolicia.entraAlEdificio( banco, unLadron );
        assertTrue(policiaEntro);
    }

    @Test
    public void test02(){

    }


}
