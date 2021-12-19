package edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones;

import edu.fiuba.algo3.modelo.Acciones.Enfrentamiento;
import edu.fiuba.algo3.modelo.Acciones.HeridaPorCuchillo;
import edu.fiuba.algo3.modelo.Acciones.IAccion;
import edu.fiuba.algo3.modelo.Edificio.AccionadorUnaVez.AccionadorUnaVez;
import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Edificio.SinAccionador;
import edu.fiuba.algo3.modelo.Ladron.Ladron;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstrategiaAccionesUltima implements IEstrategiaAcciones {
    private final Ladron ladron;

    public EstrategiaAccionesUltima(Ladron ladron) {
        this.ladron = ladron;
    }

    @Override
    public List<IAccionador> getAccionadores(int cantidad) {
        Stream<IAccionador> accionadores = Stream.of(
                (IAccion) new Enfrentamiento(ladron),
                (IAccion) new HeridaPorCuchillo()).map(AccionadorUnaVez::new);
        Stream<IAccionador> relleno = Stream
                .generate(((Supplier<IAccionador>) SinAccionador::new))
                .limit(cantidad - 1);
        return Stream.concat(accionadores,relleno).limit(cantidad).collect(Collectors.toList());
    }
}
