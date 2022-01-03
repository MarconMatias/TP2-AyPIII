package edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones;

import edu.fiuba.algo3.modelo.Edificio.IAccionador;

import java.util.List;
import java.util.Random;

public interface IEstrategiaAcciones {
    List<IAccionador> getAccionadores(int cantidad, Random random);
}
