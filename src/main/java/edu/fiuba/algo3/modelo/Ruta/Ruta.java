package edu.fiuba.algo3.modelo.Ruta;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Ciudad.DestinoFinal;
import edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones.*;
import edu.fiuba.algo3.modelo.Ciudad.IDestino;
import edu.fiuba.algo3.modelo.Ciudad.SinDestino;
import edu.fiuba.algo3.modelo.Juego.Mapa;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

import java.util.List;
import java.util.stream.Collectors;

public class Ruta {
    private final List<Ciudad> ciudades;

    public Ruta(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Ruta(List<String> nombreCiudades, Mapa mapa) {
        this(nombreCiudades.stream().map(mapa::getCiudadPorNombre).collect(Collectors.toList()));
    }

    public void visitadaPorLadron(Ladron ladron) {
        for(Ciudad ciudadVisitadaPorLadron : this.ciudades) {
            ciudadVisitadaPorLadron.actualizarRutaLadron(this,ladron);
        }
    }

    private int getCiudadesFaltantes(Ciudad ciudad) {
        return ciudades.size() - ciudades.indexOf(ciudad) - 1;
    }

    public IEstrategiaAcciones getEstrategiaAccionesPara(Ciudad ciudad, Ladron ladron) {
        int faltantes = getCiudadesFaltantes(ciudad);
        if(faltantes<0) {
            return new SinEstrategiaAcciones();
        } else if(0 == faltantes) {
            return new EstrategiaAccionesUltima(ladron);
        } else if(1 == faltantes) {
            return new EstrategiaAccionesPenultima();
        } else if(2 == faltantes) {
            return new EstrategiaAccionesAntepenultima();
        } else {
            return new EstrategiaAccionesComun();
        }

    }

    public IDestino getDestinoSospechosoDesde(Ciudad ciudad) {
        int faltantes = getCiudadesFaltantes(ciudad);
        if(faltantes<0) {
            return new SinDestino();
        } else if(0 == faltantes) {
            return new DestinoFinal();
        } else {
            int index = ciudades.indexOf(ciudad);
            return ciudades.get(index);
        }
    }
}
