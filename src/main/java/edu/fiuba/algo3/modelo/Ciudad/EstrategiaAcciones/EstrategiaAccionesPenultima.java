package edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones;


import edu.fiuba.algo3.modelo.Acciones.*;
import edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez.AccionadorUnaVez;
import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Edificio.SinAccionador;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstategiaAccionesPenultima implements IEstrategiaAcciones {
    @Override
    public List<IAccionador> getAccionadores(int cantidad) {
        Stream<IAccionador> cuchillo = Stream
                .generate(() -> (IAccionador) new AccionadorUnaVez(new HeridaPorDisparo()))
                .limit(1);
        Stream<IAccionador> relleno = Stream
                .generate(((Supplier<IAccionador>) SinAccionador::new))
                .limit(cantidad - 1);
        return Stream.concat(cuchillo,relleno).limit(cantidad).collect(Collectors.toList());
    }
}
