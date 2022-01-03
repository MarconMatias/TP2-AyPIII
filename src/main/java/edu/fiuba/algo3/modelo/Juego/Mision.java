package edu.fiuba.algo3.modelo.Juego;

import edu.fiuba.algo3.modelo.Acciones.ExcepcionesAccion.AccionException;
import edu.fiuba.algo3.modelo.Calendario.Acciones.EmitirOrden;
import edu.fiuba.algo3.modelo.Calendario.Calendario;
import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Ciudad.Mapa;
import edu.fiuba.algo3.modelo.Computadora.Computadora;
import edu.fiuba.algo3.modelo.Computadora.OrdenException;
import edu.fiuba.algo3.modelo.Edificio.Edificio;
import edu.fiuba.algo3.modelo.Calendario.Evento.PoliciaFinaliza;
import edu.fiuba.algo3.modelo.Calendario.Evento.PoliciaFinalizaListener;
import edu.fiuba.algo3.modelo.Item.Item;
import edu.fiuba.algo3.modelo.Juego.EstadoMision.EstadoMision;
import edu.fiuba.algo3.modelo.Juego.ExcepcionesCalendario.CalendarioException;
import edu.fiuba.algo3.modelo.Ladron.DetallableSospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Computadora.OrdenDeArresto.IOrden;
import edu.fiuba.algo3.modelo.Policia.ExcepcionesPolicia.PoliciaException;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Ciudad.Ruta.Ruta;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Mision implements DetallableSospechoso {
    private final Policia policia;
    private final Item itemRobado;
    private final Ladron ladron;
    private final Ruta rutaLadron;
    private final Mapa mapa;
    private final Calendario calendario;
    private final Random random;
    private final PoliciaFinalizaListener oyentePerder;
    private final PoliciaFinalizaListener oyenteGanar;
    private final InvalidationListener observadorCalendario;
    private Ciudad ciudadActual;
    private Computadora computadora;
    private EstadoMision estadoMision;
    private List<IObservadorMision> observadores = new ArrayList<IObservadorMision>();
    final List<String> tipsTiempo = List.of("Asegurarse viajar a la ciudad correcta evita perder tiempo de ida y de vuelta.",
            "Visitar un edificio por ciudad suele ser necesario para llegar a la orden en la 4ª ciudad.");

    /**
     * Inicia una misión con todos los parámetros dados.
     * 
     * @param policia       El policía que realiza la investigación.
     * @param itemRobado    El elemento que fue robado.
     * @param ladron        El ladron que realizó el robo.
     * @param rutaLadron    La ruta que tomó el ladrón.
     * @param ciudadInicial El nombre de la ciudad en la que está el policía.
     * @param computadora   La computadora de Interpol.
     * @param mapa          El mapa de ciudades.
     * @param calendario    El calendario de tiempo del juego.
     * @param random        El generador de números aleatorios.
     */
    public Mision(Policia policia, Item itemRobado, Ladron ladron, List<Ciudad> rutaLadron, String ciudadInicial,
            Computadora computadora, Mapa mapa,
            Calendario calendario, Random random) {
        this.estadoMision = new EstadoMision(itemRobado, ladron);
        this.policia = policia;
        policia.iniciarMision(calendario);
        this.itemRobado = itemRobado;
        this.ladron = ladron;
        this.rutaLadron = new Ruta(rutaLadron);
        this.computadora = computadora;
        this.mapa = mapa;
        mapa.reiniciar();
        this.calendario = calendario;
        this.random = random;
        this.rutaLadron.visitadaPorLadron(ladron);
        this.ciudadActual = mapa.getCiudadPorNombre(ciudadInicial);
        ciudadActual.visitadaPorPolicia(policia, random);
        // Observadores y oyentes
        oyentePerder = this::alPerderPolicia;
        oyenteGanar = this::alGanarPolicia;
        observadorCalendario = this::comprobarExpiracionDeMision;
        policia.escucharAlPerder(oyentePerder);
        policia.escucharAlGanar(oyenteGanar);
        calendario.getDiaObservable().addListener(observadorCalendario);
        calendario.getHoraObservable().addListener(observadorCalendario);
    }

    private void alGanarPolicia(PoliciaFinaliza evento) {
        estadoMision.hacerVictoria(evento.getExplicacion());
        finalizarMision();
    }

    private void alPerderPolicia(PoliciaFinaliza evento) {
        estadoMision.hacerDerrota(evento.getExplicacion());
        finalizarMision();
    }

    private void comprobarExpiracionDeMision(Observable observable) {
        // 0 lunes comienza
        // 1 martes, 2 miércoles, 3 jueves, 4 viernes, 5 sábado,
        if(calendario.getCantidadDeDias() < 6) {
            return;
        }
        if( (calendario.getCantidadDeDias() > 7)
                || (calendario.getHoraDelDia() >= 17) ) {
            alExpirarMision();
        }
    }

    private void alExpirarMision() {
        String tip = tipsTiempo.get(random.nextInt(tipsTiempo.size()));
        estadoMision.hacerDerrota("Se terminó el tiempo designado para la misión.\nTip:" + tip);
        finalizarMision();
    }

    private void finalizarMision() {
        policia.desescucharAlPerder(oyentePerder);
        policia.desescucharAlGanar(oyenteGanar);
        calendario.getDiaObservable().removeListener(observadorCalendario);
        calendario.getHoraObservable().removeListener(observadorCalendario);
        notificarObservadores();
    }
    /**
     * Crea una misión para un policía, con un item y ladrón al azar, ruta al azar y
     * ciudad según el ítem.
     * Para generar el ítem, ladrón y ruta usa un nuevo generador y un nuevo
     * calendario.
     * Esta sobrecarga está diseñada para ser usada "por defecto".
     * 
     * @param policia  El policía que realiza la investigación.
     * @param items    Listado de items para elegir uno como robado.
     * @param ladrones Listado de ladrones para elegir uno.
     * @param mapa     El mapa de ciudades.
     */
    public Mision(Policia policia,
            List<Item> items, List<Ladron> ladrones, Mapa mapa) {
        this(policia, items, ladrones, mapa, new Calendario(), new Random());
    }

    /**
     * Crea una misión para un policía, con un item y ladrón al azar, ruta al azar y
     * ciudad según el ítem.
     * Para generar el ítem, ladrón y ruta usa el generador dado.
     * Usado por constructor public por defecto
     * (Policia,List<Item>,List<Ladron>,Mapa).
     * 
     * @param policia    El policía que realiza la investigación.
     * @param items      Listado de items para elegir uno como robado.
     * @param ladrones   Listado de ladrones para elegir uno.
     * @param mapa       El mapa de ciudades.
     * @param calendario El calendario de tiempo del juego.
     * @param random     El generador de números aleatorios.
     */
    private Mision(Policia policia,
            List<Item> items, List<Ladron> ladrones, Mapa mapa,
            Calendario calendario, Random random) {
        this(policia, itemAlAzar(items, random), ladronAlAzar(ladrones, random),
                new Computadora(ladrones), mapa,
                calendario, random);
    }

    /**
     * Crea una misión con todos los datos dados, excepto ruta y ciudad de inicio.
     * Usado por el constructor privado (policia, List<Item>,List<Ladron>, Mapa,
     * Calendario, Random).
     * 
     * @param policia     El policía que realiza la investigación.
     * @param item        El elemento que fue robado.
     * @param ladron      El ladron que realizó el robo.
     * @param computadora La computadora de Interpol.
     * @param mapa        El mapa de ciudades.
     * @param calendario  El calendario de tiempo del juego.
     * @param random      El generador de números aleatorios.
     */
    public Mision(Policia policia, Item item, Ladron ladron,
            Computadora computadora, Mapa mapa,
            Calendario calendario, Random random) {
        this(policia, item, ladron, calcularRuta(item, mapa, random), item.getNombreCiudadDelRobo(),
                computadora, mapa, calendario, random);
    }

    /**
     * Construye una nueva misión, con ruta y ciudad de inicio en base al ítem.
     * Usado en un test.
     * 
     * @param unLadron
     * @param unPolicia    El policía que realiza la investigación.
     * @param unItem       El elemento que fue robado (el cual conoce la ciudad de
     *                     inicio y largo de ruta).
     * @param unMapa       El mapa de ciudades.
     * @param unCalendario El calendario de tiempo del juego.
     * @param random       Un generador de números.
     */
    public Mision(Ladron unLadron, Policia unPolicia, Item unItem,
            Computadora computadora, Mapa unMapa,
            Calendario unCalendario, Random random) {
        this(unPolicia, unItem, unLadron, calcularRuta(unItem, unMapa, random), unItem.getNombreCiudadDelRobo(),
                computadora, unMapa,
                unCalendario, random);
    }

    private static Item itemAlAzar(List<Item> items, Random random) {
        int indice = random.nextInt(items.size());
        return items.get(indice);
    }

    private static Ladron ladronAlAzar(List<Ladron> ladrones, Random random) {
        int indice = random.nextInt(ladrones.size());
        return ladrones.get(indice);
    }

    private static List<Ciudad> calcularRuta(Item unItem, Mapa unMapa, Random random) {
        return unItem.getRuta(unMapa, random);
    }

    public Ciudad viajarACiudad(Ciudad destino) throws PoliciaException {
        ciudadActual.desvisitar();
        ciudadActual = mapa.viajar(policia, ciudadActual, destino, random);
        return ciudadActual;
    }

    public List<Edificio> obtenerEdificios() {
        return ciudadActual.obtenerEdificios();
    }

    public void agregarDetalleLadron(String tipo, String valor) {
        computadora.agregarDetalle(tipo, valor);
    }

    /**
     * En la misión, el policía vista un edificio de la ciudad actual.
     * * Avanza el calendario por la visita misma.
     * * Puede disparar acciones que avancen a su vez el calendario.
     * 
     * @param edificio Un edificio de la ciudad actual.
     * @return El testimonio obtenido en el edificio de la ciudad actual.
     */
    public String visitarEdificio(Edificio edificio){
        return ciudadActual.visitar(edificio);
    }

    public void generarOrdenDeArresto() throws PoliciaException, OrdenException {
        try{
            IOrden orden = computadora.generarOrdenDeArresto();
            calendario.aplicarAccion(new EmitirOrden(orden, policia));
        }
        catch(OrdenException e){
            e.printStackTrace();
        }
    }

    public boolean fueFinalizada() {
        return estadoMision.fueFinalizada();
    }

    public boolean fueVictoria() {
        return estadoMision.fueVictoria();
    }

    public List<Ciudad> getCiudadesVecinas() {
        return mapa.getCiudadesVecinas(ciudadActual);
    }

    @Override
    public ObservableMap<String, String> getDetallesDeSospechoso() {
        return computadora.getDetalles();
    }

    public String getDetalle(String tipo) {
        return computadora.obtenerDetalle(tipo);
    }

    public String getMensajeMision() {
        return estadoMision.getMensaje();
    }

    public String getNombreCiudadActual() {
        return ciudadActual.getNombre();
    }

    public Ciudad getCiudadActual() {
        return ciudadActual;
    }

    public Set<String> obtenerTiposDeDetalles() {
        return computadora.getTiposDeDetalles();
    }

    public Set<String> getValoresDeDetalleTipo(String tipo) {
        return computadora.getValoresDeDetalleTipo(tipo);
    }

    public ObservableList<Ladron> getSospechososObservables() {
        return computadora.getSospechososObservables();
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public String getTestigo(Edificio edificio) {
        return edificio.getTestigo();
    }

    public ObjectProperty<IOrden> getOrden() {
        return policia.getOrdenDeArresto();
    }

    public void observarMision(IObservadorMision observadorMision) {
        observadores.add(observadorMision);
    }
    public void desobservarMision(IObservadorMision observadorMision) {
        observadores.remove(observadorMision);
    }
    public void notificarObservadores() {
        // Hace una copia porque a veces modificado durante la llamada a los observadores:
        IObservadorMision[] observadoresAntes = observadores.toArray(new IObservadorMision[0]);
        for(IObservadorMision observador : observadoresAntes) {
            try {
                // Debe verificar si sigue estando (ya que usa una copia):
                if(observadores.contains(observador)) {
                    observador.misionCambia(this);
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getRangoYNombrePolicia() {
        return policia.getRangoYNombre();
    }
}
