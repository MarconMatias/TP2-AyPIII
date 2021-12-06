package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.Banco;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

public class TestsJuego {

    //Casos de usos
    @Test

    public void test01CasoDeUso1ElLadronRobaUnTesoroNacionalDeMontrealSospechosoFemeninoYDetectiveNovatoEncuentraPistaEnUnBanco() throws IOException {

        boolean policiaEntro = false;
        Policia nuevoPolicia = new Policia((new RangoPolicia()),"Agus");
        Ladron unLadron = new Ladron("Ada","Femenino","Jockey sobre Hielo","Rubio","anillo de oro","Moto");
        Edificio banco = new Edificio(new Banco()); //En vez de usar un campo true podria settearse con Strategy el comportamiento de un Edificio para que muestre una pista o no
        policiaEntro = nuevoPolicia.entraAlEdificio(banco, unLadron);
        assertTrue(policiaEntro);
    }

    @Test
    public void test02DetectiveNovatoComienzaEnMontrealVisitaUnBancoSeDespliegaUnaPistaLuegoVisitaUnaBibliotecaSeDespliegaUnaPista(){

        Policia nuevoPolicia = new Policia( new RangoPolicia(), "Agus");
        Ladron ladron = new Ladron("Tomas" , "Masculino" ,"Futbol","Castaño Oscuro", "Tatuaje","Auto de marca alemana");
        IEdificio banco = (IEdificio) new Banco("Banco de Montreal");
        IEdificio biblioteca = new Biblioteca("Biblioteca de Montreal");

        boolean policiaEntro = nuevoPolicia.entraAlEdificio(banco, ladron);
        assertTrue(policiaEntro);
        policiaEntro = nuevoPolicia.entraAlEdificio(biblioteca,ladron);
        assertTrue(policiaEntro);

    }

    @Test
    public void test03DetectiveViajaDeMontrealAMexico(){

        boolean policiaViajo = false;
        Policia nuevoPolicia = new Policia( new RangoPolicia(), "Agus");
        Ladron ladron = new Ladron("Tomas" , "Masculino" ,"Futbol","Castaño Oscuro", "Tatuaje","Auto de marca alemana");
        Ciudad mexico = new Ciudad("Mexico DF");
        policiaViajo = nuevoPolicia.viajarACiudad(mexico);
        assertTrue(policiaViajo);
        
    }

    @Test
    public void test04DetectiveEntraAUnAeropuertoYLuegoAlPuertoEnAmbosCasosSeDespliegaUnaPista(){

        boolean policiaViajo = false;
        Policia nuevoPolicia = new Policia( new RangoPolicia(), "Agus");
        Ladron ladron = new Ladron("Tomas" , "Masculino" ,"Futbol","Castaño Oscuro", "Tatuaje","Auto de marca alemana");
        Edifico aeropuerto
    }
}
