package edu.fiuba.algo3.modelo.Pista;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PistaCiudadTest {
    @Test
    public void pistaNivelFacilEsAgregadaAListaNivelFacil(){
        ArrayList<IPista> lista = new ArrayList<>();
        NivelPista nivelObtenido = new PistaFacil();
        NivelPista nivelBuscado = new PistaFacil();

        IPista pista = new PistaCiudad("Bandera", "Verde, blanca y roja", nivelObtenido);
        pista.agregarAListaSiEsNivel(lista,nivelBuscado);

        assertSame(lista.get(0), pista);
    }

    @Test
    public void pistaNivelFacilNOEsAgregadaAListaNivelMediaODificil() {
        ArrayList<IPista> lista = new ArrayList<>();
        NivelPista nivelObtenido = new PistaFacil();


        IPista pista = new PistaCiudad("Bandera", "Verde, blanca y roja", nivelObtenido);
        pista.agregarAListaSiEsNivel(lista,new PistaMedia());
        pista.agregarAListaSiEsNivel(lista,new PistaDificil());

        assertEquals(0, lista.size());
    }

    @Test
    public void pistaNivelMediaEsAgregadaAListaNivelMedia(){
        ArrayList<IPista> lista = new ArrayList<>();
        NivelPista nivelObtenido = new PistaMedia();
        NivelPista nivelBuscado = new PistaMedia();

        IPista pista = new PistaCiudad("Paisajes", "Monte Popocatepetl", nivelObtenido);
        pista.agregarAListaSiEsNivel(lista,nivelBuscado);

        assertSame(lista.get(0), pista);
    }

    @Test
    public void pistaNivelMediaNOEsAgregadaAListaNivelFacilODificil() {
        ArrayList<IPista> lista = new ArrayList<>();
        NivelPista nivelObtenido = new PistaMedia();

        IPista pista = new PistaCiudad("Paisajes", "Monte Popocatepetl", nivelObtenido);
        pista.agregarAListaSiEsNivel(lista,new PistaFacil());
        pista.agregarAListaSiEsNivel(lista,new PistaDificil());

        assertEquals(0, lista.size());
    }

    @Test
    public void pistaNivelDificilEsAgregadaAListaNivelDificil(){
        ArrayList<IPista> lista = new ArrayList<>();
        NivelPista nivelObtenido = new PistaDificil();
        NivelPista nivelBuscado = new PistaDificil();

        IPista pista = new PistaCiudad("Paisajes", "Sierra Madre", nivelObtenido);
        pista.agregarAListaSiEsNivel(lista,nivelBuscado);

        assertSame(lista.get(0), pista);
    }

    @Test
    public void pistaNivelDificilNOEsAgregadaAListaNivelFacilOMedia() {
        ArrayList<IPista> lista = new ArrayList<>();
        NivelPista nivelObtenido = new PistaDificil();

        IPista pista = new PistaCiudad("Paisajes", "Sierra Madre", nivelObtenido);
        pista.agregarAListaSiEsNivel(lista,new PistaFacil());
        pista.agregarAListaSiEsNivel(lista,new PistaMedia());

        assertEquals(0, lista.size());
    }

}
