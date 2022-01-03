package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones.IEstrategiaAcciones;
import edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones.SinEstrategiaAcciones;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.*;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Ladron.SinSospechoso;
import edu.fiuba.algo3.modelo.Pista.ExcepcionesPista.PistaException;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroEconomia;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroHistoria;
import edu.fiuba.algo3.modelo.Pista.Filtro.FiltroPais;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaDificil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaFacil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaMedia;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Pista.SinPistaCiudad;
import edu.fiuba.algo3.modelo.Ciudad.Ruta.Ruta;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ciudad implements IDestino, Comparable<Ciudad> {
    private final static ArrayList<Function<Random, Edificio>> factories = new ArrayList<>(
            List.of(
                    (Random random) -> new Edificio(new Aeropuerto(), random),
                    (Random random) -> new Edificio(new Banco(), random),
                    (Random random) -> new Edificio(new Biblioteca(), random),
                    (Random random) -> new Edificio(new Bolsa(), random),
                    (Random random) -> new Edificio(new Puerto(), random)
            )
    );

    private final String nombre;
    private final Collection<PistaCiudad> pistas;
    private String descripcion;
    private double coordenadaX=0.5, coordenadaY=0.5;
    private ISospechoso sospechoso;
    private ICiudadVisitada visitada;
    private IDestino destinoSospechoso;
    private IEstrategiaAcciones estrategiaAcciones;

    public Ciudad(String nombre, Collection<PistaCiudad> pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
        reiniciar();
    }

    public void reiniciar() {
        sospechoso = new SinSospechoso();
        visitada = new CiudadNoVisitada();
        destinoSospechoso = new SinDestino();
        estrategiaAcciones = new SinEstrategiaAcciones();
    }

    public void actualizarRutaLadron(Ruta rutaLadron, Ladron ladron)
    {
        sospechoso = (null==ladron)?new SinSospechoso():ladron;
        destinoSospechoso = rutaLadron.getDestinoSospechosoDesde(this);
        estrategiaAcciones = rutaLadron.getEstrategiaAccionesPara(this, ladron);
    }

    @Override
    public int compareTo(Ciudad otra) {
        return otra.compareTo(this.getNombre());
    }

    public int compareTo(String nombreOtraCiudad) {
        return this.getNombre().compareTo(nombreOtraCiudad);
    }

    public void desvisitar() {
        this.visitada = new CiudadNoVisitada();
    }

    /**
     * Crea una lista de como máximo `max` edificios válidos para la ciudad, sin repetirlos.
     * @param max
     * @return Lista de Edificios sin que haya pasado el ladrón.
     */
    public List<Edificio> edificiosAlAzar(int max, Random random) {
        List<Function<Random,Edificio>> aleatorizadas = factories.stream().collect(Collectors.toList());
        Collections.shuffle(aleatorizadas, random);
        return factories.stream().limit(max).map(
                factory -> factory.apply(random)
        ).collect(Collectors.toList());
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Edificio> obtenerEdificios() {
        return visitada.obtenerEdificios();
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

    public void setCoordenadas(double x, double y) {
        coordenadaX = x;
        coordenadaY = y;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void visitadaPorPolicia(Policia policia, Random random) {
        visitada = new CiudadVisitada(this, policia, sospechoso,
                destinoSospechoso, estrategiaAcciones, random);
    }

    public void visitadaPorPolicia(Policia policia) {
        visitadaPorPolicia(policia, new Random());
    }
    /**
     * El policía que está visitando esta ciudad, vista al edificio dado.
     * * Avanza el calendario por la visita misma.
     * * Puede disparar acciones que avancen a su vez el calendario.
     * @param edificio Un edificio de la ciudad actual.
     * @return El testimonio obtenido en el edificio de la ciudad actual.
     */
    public String visitar(Edificio edificio) throws AccionException, CalendarioException, PoliciaException {

        String testimonio = null;
        testimonio = visitada.visitar(edificio);
        return testimonio;

    }

    public Integer verificarTieneTodasLasPistas() throws PistaException {

        boolean tieneTodasLasPistas = false;
        FiltroEconomia fe = new FiltroEconomia();
        FiltroHistoria fh = new FiltroHistoria();
        FiltroPais fp = new FiltroPais();

        tieneTodasLasPistas = (fe.filtrarPistas(pistas).stream().filter( p -> p.conDificultad( (Object) new PistaFacil())).count() > 2);
        if(!tieneTodasLasPistas)
            throw new PistaException("Error. No tiene todas las pistas faciles requeridas la ciudad");
        tieneTodasLasPistas = (fh.filtrarPistas(pistas).stream().filter( p -> p.conDificultad( (Object) new PistaMedia() )).count() > 2);
        if(!tieneTodasLasPistas)
            throw new PistaException("Error. No tiene todas las pistas medias requeridas la ciudad");
        tieneTodasLasPistas = (fp.filtrarPistas(pistas).stream().filter( p -> p.conDificultad( (Object) new PistaDificil() )).count() > 2);
        if(!tieneTodasLasPistas)
            throw new PistaException("Error. No tiene todas las pistas dificiles requeridas la ciudad");
        return 0;
    }

}