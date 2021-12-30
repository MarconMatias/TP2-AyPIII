package edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones;


import edu.fiuba.algo3.modelo.Acciones.HeridaPorDisparo;
import edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez.AccionadorUnaVez;
import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Edificio.SinAccionador;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstrategiaAccionesPenultima implements IEstrategiaAcciones {
    @Override
    public List<IAccionador> getAccionadores(int cantidad, Random random) {
        Stream<IAccionador> disparo = Stream
                .generate(() -> (IAccionador) new AccionadorUnaVez(new HeridaPorDisparo()))
                .limit(1);
        Stream<IAccionador> relleno = Stream
                .generate(((Supplier<IAccionador>) SinAccionador::new))
                .limit(cantidad - 1);
        List<IAccionador> lista = Stream.concat(disparo, relleno).limit(cantidad)
                .collect(Collectors.toList());
        Collections.shuffle(lista, random);
        return lista;
    }
}
