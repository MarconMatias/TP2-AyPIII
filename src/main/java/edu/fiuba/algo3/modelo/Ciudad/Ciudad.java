package edu.fiuba.algo3.modelo.Ciudad;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.EstadoVisitasCiudad;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.*;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Pista.*;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.NivelPista.NivelPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaDificil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaFacil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaMedia;
import edu.fiuba.algo3.modelo.Policia.*;

public class Ciudad {

    private final String nombre;
    private final ArrayList<PistaCiudad> pistas;
    private EstadoVisitasCiudad visitas = new EstadoVisitasCiudad();

    public Ciudad(String nombre, ArrayList<PistaCiudad> pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
    }

    public CiudadVisitada visitar(Policia policia, Calendario calendario) {
        return new CiudadVisitada(this,policia,calendario);
    }

    public boolean esLaCiudad(String nombre) {
        return this.nombre.equals(nombre);
    }

    private final static ArrayList<Supplier<Edificio>> factories = new ArrayList<>(
            List.of(
                    () -> new Edificio(new Banco()),
                    () -> new Edificio(new Bolsa()),
                    () -> new Edificio(new Banco())
            )
    );

    public List<Edificio> edificiosAlAzar(int max) {
        Collections.shuffle(factories);
        return factories.stream().limit(max).map(factory -> factory.get()).collect(Collectors.toList());
    }

    public IPista pistaAlAzar(Policia policia, IFiltroCiudad filtroCiudad) {
        List<PistaCiudad> filtradaPorEdificio = filtroCiudad.filtrarPistas(pistas);
        List<IPista> filtrada = new ArrayList<>(policia.filtrarPistas(filtradaPorEdificio));
        int largo = filtrada.size();
        if( 0 == largo)
            return new SinPistaCiudad();
        int posicion = (new Random()).nextInt(largo);
        return filtrada.get(posicion);
    }

    public String getNombre() {
        return this.nombre;
    }
}
