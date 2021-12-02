package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Juego.Juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

public class TestsJuego {

    @Test
    public void test01SeLeeElArchivoDeDossiersYSeCarganEfectivamenteTodosLosLadrones() throws IOException {

        /* Arrange */
        Juego nuevoJuego = new Juego();
        nuevoJuego.leerLadrones();
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
    public void test02SeLeeElArchivoDePistasPaisesYSeCarganEfectivamenteTodasLasPistasDeLosPaises() throws IOException {

        Juego nuevoJuego = new Juego();
        nuevoJuego.leerPistas();
        assertTrue(nuevoJuego.existeLaPistaDeLaCiudad("Athens"));
        assertTrue(nuevoJuego.existeLaPistaDeLaCiudad("Baghdag"));
        assertTrue(nuevoJuego.existeLaPistaDeLaCiudad("Bangkok"));
        assertTrue(nuevoJuego.existeLaPistaDeLaCiudad("Budapest"));
        assertTrue(nuevoJuego.existeLaPistaDeLaCiudad("Buenos Aires"));
        assertTrue(nuevoJuego.existeLaPistaDeLaCiudad("Cairo"));

    }
}
