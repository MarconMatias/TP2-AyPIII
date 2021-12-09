package edu.fiuba.algo3.modelo.Ciudad;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import edu.fiuba.algo3.modelo.Edificio.Edificio;
<<<<<<< HEAD
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
=======
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.*;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Ladron.SinSospechoso;
import edu.fiuba.algo3.modelo.Pista.*;
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Policia.*;

public class Ciudad {

    private final String nombre;
    private final ArrayList<PistaCiudad> pistas;
<<<<<<< HEAD
    private final ArrayList<Ciudad> ciudadesVecinas;
    private ArrayList<Edificio> edificios = new ArrayList<Edificio>();

    private int cantidadDeVisitas = 0;

    public Ciudad(String nombre, ArrayList<PistaCiudad> pistas, ArrayList<Ciudad> ciudadVecinas, ArrayList<Edificio> edificios) {
        this.nombre = nombre;
        this.pistas = pistas;
        this.ciudadesVecinas = ciudadVecinas;
        this.edificios = edificios;
=======
    private ISospechoso sospechoso = new SinSospechoso();
    private ICiudadVisitada visitada = new CiudadNoVisitada();
    private Ciudad destinoSospechoso = null;

    public Ciudad(String nombre, ArrayList<PistaCiudad> pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
    }

    public boolean esLaCiudad(String nombre) {
        return this.nombre.equals(nombre);
    }
    public boolean esLaCiudad(Ciudad otraCiudad) {
        return otraCiudad.esLaCiudad(this.nombre);
    }

    public String getNombre() {
        return this.nombre;
    }

    private final static ArrayList<Supplier<Edificio>> factories = new ArrayList<>(
            List.of(
                    () -> new Edificio(new Aeropuerto()),
                    () -> new Edificio(new Banco()),
                    () -> new Edificio(new Biblioteca()),
                    () -> new Edificio(new Bolsa()),
                    () -> new Edificio(new Puerto())
            )
    );

    /**
     * Crea una lista de como máximo `max` edificios válidos para la ciudad, sin repetirlos.
     * @param max
     * @return Lista de Edificios sin que haya pasado el ladrón.
     */
    public List<Edificio> edificiosAlAzar(int max) {
        Collections.shuffle(factories);
        return factories.stream().limit(max).map(factory -> factory.get()).collect(Collectors.toList());
    }

    /**
     * Devuelve al azar una pista sobre esta ciudad, filtrándola por la estrategia del policía dado
     * y por el filtro de pistas de ciudad indicado.
     * @param policia Policía que debe detectar la pista.
     * @param filtroCiudad Una estrategia dada para filtrar pistas de ciudad.
     * @return Una pista válida sobre la ciudad o un SinPistaCiudad.
     */
    public IPista pistaAlAzar(Policia policia, IFiltroCiudad filtroCiudad) {
        List<IPista> filtradaPorEdificio = new ArrayList<>(filtroCiudad.filtrarPistas(pistas));
        List<IPista> filtrada = new ArrayList<>(policia.filtrarPistas(filtradaPorEdificio));
        int largo = filtrada.size();
        if (0 == largo)
            return new SinPistaCiudad();
        int posicion = (new Random()).nextInt(largo);
        return filtrada.get(posicion);
    }

    public void visitadaPorPolicia(Policia policia) {
        visitada = new CiudadVisitada(this, policia, sospechoso, destinoSospechoso);
    }

    public void actualizarRutaLadron(List<Ciudad> rutaLadron, Ladron ladron)
    {
        this.sospechoso = new SinSospechoso();
        this.destinoSospechoso = null;
        int indice = rutaLadron.indexOf(this);
        if(indice>=0) {
            this.sospechoso = ladron;
            int indiceSiguiente = indice+1;
            if(indiceSiguiente < rutaLadron.size()) {
                this.destinoSospechoso = rutaLadron.get(indiceSiguiente);
            }
        }
    }

    public void desvisitar() {
        this.visitada = new CiudadNoVisitada();
    }

    public List<Edificio> obtenerEdificios() {
        return visitada.obtenerEdificios();
    }
<<<<<<< HEAD

    public boolean visitar(String nombreDelEdificioAVisitar, Ladron unLadron, Policia unPolicia) {

        for ( Edificio e : edificios){
            if( e.esElEdificio(nombreDelEdificioAVisitar)) {
                unPolicia.visitar(e, unLadron);
                return true;
                }
            }
        return false;
    }
}
=======
}
>>>>>>> 96100e3de4a8b4265ef50acb2dad73b2dcb5042e
