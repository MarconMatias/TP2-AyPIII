package edu.fiuba.algo3.modelo.Lector;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Pista.PistaCiudad;
import org.json.simple.JSONArray;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class LectorCiudad {
  LectorJson lector = new LectorJson();
  InterpretePistaCiudad interprete = new InterpretePistaCiudad();
  private BiFunction<String, Collection<PistaCiudad>, Ciudad> constructor;

  public LectorCiudad(BiFunction<String, Collection<PistaCiudad>,Ciudad> constructor) {
    this.constructor = constructor;
  }

  public LectorCiudad() {
    this(Ciudad::new);
  }

  public Map<String,Ciudad> leerCiudades() throws LectorException {
    return leerCiudadesMap("/edu/fiuba/algo3/ciudades.json");
  }

  public List<Ciudad> leerCiudades(String ruta) throws LectorException {
    return leerCiudades(lector.leerJsonMap(ruta));
  }

  public Map<String,Ciudad> leerCiudadesMap(String ruta) throws LectorException {
    return lector.mapear(leerCiudades(ruta), Ciudad::getNombre);
  }

  public ArrayList<Ciudad> leerCiudades(java.io.Reader lectorDatos) throws LectorException {
    return leerCiudades(lector.leerJsonMap(lectorDatos));
  }

  public Map<String,Ciudad> leerCiudadesMap(java.io.Reader lectorDatos) throws LectorException {
    return lector.mapear(leerCiudades(lectorDatos), Ciudad::getNombre);
  }

  public ArrayList<Ciudad> leerCiudades(Map parseado) throws LectorException {
    ArrayList jsonCiudades = lector.leerPropiedadComo(ArrayList.class,parseado,"ciudades");
    return lector.interpetarArray(jsonCiudades, this::interpretarCiudad);
  }

  public Map<String,Ciudad> leerCiudadesMap(Map parseado) throws LectorException {
    return lector.mapear(leerCiudades(parseado), Ciudad::getNombre);
  }

  private Ciudad interpretarCiudad(Map jsonCiudad) {
    String nombre = (String) jsonCiudad.get("nombre");
    ArrayList<PistaCiudad> pistas = interprete.interpretar((JSONArray) jsonCiudad.get("pistas"));
    Ciudad ciudad = constructor.apply(nombre, pistas);
    agregarCoordenadas(jsonCiudad, ciudad);
    agregarDescripcion(jsonCiudad, ciudad);
    return ciudad;
  }

  private void agregarCoordenadas(Map jsonCiudad, Ciudad ciudad) {
    List coords = lector.leerPropiedadComo(List.class, jsonCiudad, "coordenadas", null);
    if( (null != coords) && (2 == coords.size()) ) {
      try {
        Number x = (Number) coords.get(0);
        Number y = (Number) coords.get(1);
        ciudad.setCoordenadas(x.doubleValue(), y.doubleValue());
      } catch(RuntimeException ex) {
        ex.printStackTrace();
      }
    } else {
      //System.err.println("Advertencia: La ciudad "+ciudad.getNombre()+" no tiene coordenadas.");
    }
  }

  public void agregarDescripcion(Map jsonCiudad, Ciudad ciudad) {
    String desc = lector.leerPropiedadComo(String.class, jsonCiudad, "descripcion", null);
    if((null==desc) || ("".equals(desc.trim()))) {
      String ciudadURL = ciudad.getNombre().replace(" ","_");
      String wiki = "https://es.wikipedia.org/wiki/"+URLEncoder.encode(ciudadURL, StandardCharsets.UTF_8);
      //System.err.println("Advertencia: La ciudad "+ciudad.getNombre()+" no tiene descripcion. Véase "+wiki);
    } else {
      ciudad.setDescripcion(desc);
    }
  }

}