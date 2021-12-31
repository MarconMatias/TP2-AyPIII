package edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones;

import edu.fiuba.algo3.modelo.Edificio.IAccionador;
import edu.fiuba.algo3.modelo.Edificio.SinAccionador;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SinEstrategiaAcciones implements IEstrategiaAcciones {
    @Override
    public List<IAccionador> getAccionadores(int cantidad, Random random) {
        return Stream.generate(SinAccionador::new).limit(cantidad).collect(Collectors.toList());
    }
}
