package edu.fiuba.algo3.modelo.Edificio.TipoEdificio;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Pista.Filtro.IFiltroCiudad;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface ITipoEdificio extends IFiltroCiudad {
    public String getNombreTipo();
    Testigo getTestigo();

    boolean mostrarPista(Ladron unLadron);

    void visitadoPorLadron(Ladron ladron, Ciudad destino);

    void visitar(Policia policia, Calendario cal);
}
