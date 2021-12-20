package edu.fiuba.algo3.modelo.Ciudad.EstrategiaAcciones;

import edu.fiuba.algo3.modelo.Edificio.IAccionador;

import java.util.List;

public interface IEstrategiaAcciones {
    List<IAccionador> getAccionadores(int cantidad);
}
