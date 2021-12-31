package edu.fiuba.algo3.modelo.Ladron;

import edu.fiuba.algo3.modelo.Ciudad.IDestino;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Pista.IPista;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaDificil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaFacil;
import edu.fiuba.algo3.modelo.Pista.NivelPista.PistaMedia;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import edu.fiuba.algo3.modelo.Pista.PistaLadron;
import edu.fiuba.algo3.modelo.Pista.PistaLadronNoFacil;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.*;
import java.util.stream.Collectors;

public class Ladron implements ISospechoso, DetallableSospechoso {
  private final String nombre;
  private final Map<String,String> detalles;
  private final List<IPista> pistas = new ArrayList<>();

  public Ladron(String nombre, Map<String,String> detalles) {
    this.nombre = nombre;
    this.detalles = detalles;
  }

  private static Map<String,String> crearDetalles(String sexo, String deporte, String cabello, String distincion, String vehiculo)
  {
    Map<String,String> map = new HashMap<String,String>();
    map.put("sexo", sexo);
    map.put("deporte", deporte);
    map.put("cabello", cabello);
    map.put("distincion", distincion);
    map.put("vehiculo", vehiculo);
    return map;
  }
  public Ladron(String nombre, String sexo, String deporte, String cabello, String distincion, String vehiculo) {
    this(nombre, crearDetalles(sexo,deporte,cabello,distincion,vehiculo));
  }

  private void generarPistas() {
    if(0 == detalles.size()) {
      System.err.println(this + " no tiene detalles.");
      return;
    }
    PistaFacil facil = new PistaFacil();
    Collection<PistaLadron> faciles = detalles.keySet().stream()
            .map(tipo -> new PistaLadron(tipo, detalles.get(tipo), facil))
                    .collect(Collectors.toList());
    pistas.addAll(faciles);

    PistaMedia media = new PistaMedia();
    Collection<PistaLadron> medias = detalles.keySet().stream()
            .map(tipo -> new PistaLadronNoFacil(tipo, detalles.get(tipo), media, 2))
            .collect(Collectors.toList());
    pistas.addAll(medias);

    PistaDificil dificil = new PistaDificil();
    Collection<PistaLadron> dificiles = detalles.keySet().stream()
            .map(tipo -> new PistaLadronNoFacil(tipo, detalles.get(tipo), dificil, 1))
            .collect(Collectors.toList());
    pistas.addAll(dificiles);
  }

  public String getDetalle(String tipo, String porDefecto)
  {
    return this.detalles.getOrDefault(tipo,porDefecto);
  }

  public String detalleAlAzar(Policia policia, Random random) {
    // Generación lazy.
    if(0 == pistas.size()) {
      generarPistas();
    }

    List<IPista> filtrada = policia.filtrarPistas(pistas);
    int largo = filtrada.size();
    if (0 == largo)
      return PistaLadron.textoNoHay();
    int posicion = random.nextInt(largo);
    return filtrada.get(posicion).toString();
  }

  @Override
  public String testimonioAlAzar(Policia policia, IDestino destino,
                                 IFiltroCiudad filtroCiudad) {
    PistaCiudad pistaCiudad = (PistaCiudad) destino.pistaAlAzar(policia, filtroCiudad);
    String pistaDetalle = detalleAlAzar(policia, new Random());
    return pistaCiudad.getValor() + ".\n" + pistaDetalle;
  }

    public String getNombre() {
      return this.nombre;
    }

  public void agregarSiCoincideDetalle(Map<String, String> detallesBuscados, ArrayList<Ladron> sospechososFiltrados) {

    for (String tipo : detallesBuscados.keySet()) {
      String valorBuscado = detallesBuscados.get(tipo).trim();
      String valorDeEste = this.detalles.get(tipo.trim());
      if(!valorBuscado.equals(valorDeEste)) {
        return;
      }
    }
    sospechososFiltrados.add(this);
  }

  public void agregarDetallesAMap(Map<String, Set<String>> map) {
    for(String tipo : detalles.keySet()) {
      tipo = tipo.trim();
      String valor = detalles.get(tipo).trim();
      if(!map.containsKey(tipo)) {
        map.put(tipo, new HashSet<String>(Set.of(valor)));
      } else {
        map.get(tipo).add(valor);
      }
    }
  }

  @Override
  public String toString() {
    if((null==nombre)||(nombre.trim().equals(""))) {
      return Integer.toString(hashCode());
    }
    return nombre;
  }

    @Override
    public ObservableMap<String, String> getDetallesDeSospechoso() {
        return FXCollections.observableMap(detalles);
    }

    @Override
    public String getDetalle(String tipo) {
        return detalles.get(tipo);
    }

  public String getTextoMision() {
    String sexo = detalles.get("sexo");
    boolean esFemenino = "Femenino".equals(sexo);
    String texto = esFemenino ? "Una sospechosa de sexo femenino" : "Un sospechoso de sexo "+sexo;
    texto +=" ha sido " + (esFemenino?"vista":"visto") + " en la escena del crimen.";
    return texto;
  }
}
