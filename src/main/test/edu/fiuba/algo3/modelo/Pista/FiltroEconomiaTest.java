package edu.fiuba.algo3.modelo.Pista;

import edu.fiuba.algo3.modelo.Pista.Filtro.*;
import edu.fiuba.algo3.modelo.Pista.NivelPista.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FiltroEconomiaTest {
    @Test
    public void sinPistasDevuelveListaVacia()
    {
        Collection<PistaCiudad> entrada = new ArrayList<PistaCiudad>();
        IFiltroCiudad filtro = new FiltroEconomia();
        List<PistaCiudad> salida = filtro.filtrarPistas(entrada);

        assertEquals(0, salida.size());
    }

    public void sinPistasEconomicasDevuelveListaVacia()
    {
        NivelPista facil = new PistaFacil();
        NivelPista media = new PistaMedia();
        NivelPista dificil = new PistaDificil();

        Collection<PistaCiudad> entrada = new ArrayList<PistaCiudad>(List.of(
                new PistaCiudad("Historia","AAAAA",facil),
                new PistaCiudad("Historia","BBBBB",media),
                new PistaCiudad("Historia","CCCCC",dificil),
                new PistaCiudad("Geografía","AAAAA",facil),
                new PistaCiudad("Geografía","BBBBB",media),
                new PistaCiudad("Geografía","CCCCC",dificil),
                new PistaCiudad("Bandera","AAAAA",facil),
                new PistaCiudad("Bandera","BBBBB",media),
                new PistaCiudad("Bandera","CCCCC",dificil),
                new PistaCiudad("Idioma","AAAAA",facil),
                new PistaCiudad("Idioma","BBBBB",media),
                new PistaCiudad("Idioma","CCCCC",dificil)
        ));
        IFiltroCiudad filtro = new FiltroEconomia();
        List<PistaCiudad> salida = filtro.filtrarPistas(entrada);

        assertEquals(0, salida.size());
    }

    @Test
    public void Con2Moneda2ExportacionesY4DeOtroTipoRecibeLas4Economicas()
    {
        NivelPista facil = new PistaFacil();
        NivelPista media = new PistaMedia();
        NivelPista dificil = new PistaDificil();

        PistaCiudad valida1 = new PistaCiudad("Moneda","AAAAA",facil);
        PistaCiudad valida2 = new PistaCiudad("Exportaciones","BBBBB",dificil);
        PistaCiudad valida3 = new PistaCiudad("Moneda","CCCCC",dificil);
        PistaCiudad valida4 = new PistaCiudad("Exportaciones","DDDDD",media);

        Collection<PistaCiudad> entrada = new ArrayList<PistaCiudad>(List.of(
                new PistaCiudad("Historia","AAAAA",facil),
                new PistaCiudad("Historia","BBBBB",media),
                new PistaCiudad("Historia","CCCCC",dificil),
                new PistaCiudad("Geografía","AAAAA",facil),
                valida1,
                new PistaCiudad("Geografía","BBBBB",media),
                new PistaCiudad("Geografía","CCCCC",dificil),
                new PistaCiudad("Bandera","AAAAA",facil),
                valida2,
                new PistaCiudad("Bandera","BBBBB",media),
                new PistaCiudad("Bandera","CCCCC",dificil),
                valida3,
                new PistaCiudad("Idioma","AAAAA",facil),
                valida4,
                new PistaCiudad("Idioma","BBBBB",media),
                new PistaCiudad("Idioma","CCCCC",dificil)
        ));
        IFiltroCiudad filtro = new FiltroEconomia();
        List<PistaCiudad> salida = filtro.filtrarPistas(entrada);

        assertEquals(4, salida.size());
        assertTrue(salida.contains(valida1));
        assertTrue(salida.contains(valida2));
        assertTrue(salida.contains(valida3));
        assertTrue(salida.contains(valida4));
    }
}
