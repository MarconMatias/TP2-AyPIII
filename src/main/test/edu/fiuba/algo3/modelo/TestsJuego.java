package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.RangoPolicia.PoliciaNovato;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Juego.Juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

public class TestsJuego {

    @Test
    public void test01SeLeeElArchivoDeDossiersYSeCarganEfectivamenteTodosLosLadrones() throws IOException {

        /* Arrange */
        Juego nuevoJuego = new Juego();
        assertTrue(nuevoJuego.existeElLadron("Nick Brunch"));
        assertTrue(nuevoJuego.existeElLadron("Len Bulk"));
        assertTrue(nuevoJuego.existeElLadron("Ihor Ihorovitch"));
        assertTrue(nuevoJuego.existeElLadron("Fast Eddie B."));
        assertTrue(nuevoJuego.existeElLadron("Scar Graynolt"));
        assertTrue(nuevoJuego.existeElLadron("Merey Laroc"));
        assertTrue(nuevoJuego.existeElLadron("Lady Agatha"));
        assertTrue(nuevoJuego.existeElLadron("Katherine Drib"));
        assertTrue(nuevoJuego.existeElLadron("Dazzle Annie"));
        assertTrue(nuevoJuego.existeElLadron("Carmen Sandiego"));

    }

    @Test
    public void test02SeLeeElArchivoDeCiudadesYSeCarganEfectivamenteTodasLasCiudades() throws IOException {

        Juego nuevoJuego = new Juego();
        assertTrue(nuevoJuego.existeLaCiudad("Athens"));
        assertTrue(nuevoJuego.existeLaCiudad("Baghdag"));
        assertTrue(nuevoJuego.existeLaCiudad("Bamako"));
        assertTrue(nuevoJuego.existeLaCiudad("Bangkok"));
        assertTrue(nuevoJuego.existeLaCiudad("Budapest"));
        assertTrue(nuevoJuego.existeLaCiudad("Buenos Aires"));
        assertTrue(nuevoJuego.existeLaCiudad("Cairo"));

    }

    @Test
    public void test03SeLeeElArchivoDeAgentesYSeCarganEfectivamenteTodosLosAgentes() throws IOException {

        Juego nuevoJuego = new Juego();
        assertTrue(nuevoJuego.existeElAgente("Agus"));
        assertTrue(nuevoJuego.existeElAgente("Matias"));
        assertTrue(nuevoJuego.existeElAgente("Brenda"));
        assertTrue(nuevoJuego.existeElAgente("Eloy"));
        assertTrue(nuevoJuego.existeElAgente("Joaquin"));
        assertTrue(nuevoJuego.existeElAgente("Marcos"));

    }

    @Test
    public void test04SeLeeElArchivoDeItemsYSeCarganEfectivamenteTodosLosItems() throws IOException {

        Juego nuevoJuego = new Juego();
        assertTrue(nuevoJuego.existeElItem("1,000 Year Old Egg"));
        assertTrue(nuevoJuego.existeElItem("Babylonian Tablet"));
        assertTrue(nuevoJuego.existeElItem("Boar's Tusk"));
        assertTrue(nuevoJuego.existeElItem("Chandelier from the Opera House"));

    }

    //Casos de usos

    @Test

    public void test05CasoDeUso1ElLadronRobaUnTesoroNacionalDeMontrealSospechosoFemeninoYDetectiveNovatoEncuentraPistaEnUnBanco() throws IOException {

        Policia nuevoPolicia = new Policia((new PoliciaNovato()),"Agus");
        Ladron unLadron = new Ladron("Ada","Femenino","Jockey sobre Hielo","Rubio","anillo de oro","Moto");
        Edificio banco = new Edificio("Banco de Montreal", true ); //En vez de usar un campo true podria settearse con Strategy el comportamiento de un Edificio para que muestre una pista o no
        assertTrue(nuevoPolicia.entraAlEdificio(banco, unLadron) );
    }


}
