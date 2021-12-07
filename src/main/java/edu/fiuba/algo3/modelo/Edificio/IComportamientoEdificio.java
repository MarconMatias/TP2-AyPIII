package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public interface IComportamientoEdificio {

    IComportamientoEdificio lanzarEvento(Ladron unLadron);
<<<<<<< HEAD
    void visitar(Edificio edificio, Policia policia, Calendario cal);
}
=======
    void visitar(ITipoEdificio edificio, Policia policia, Calendario cal);
}
>>>>>>> 98e67cf7bebb438f2023ea83de30f8ebb1031c8f
