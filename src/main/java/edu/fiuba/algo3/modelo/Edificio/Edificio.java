package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Ciudad.Ciudad;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Juego.Calendario;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

public class Edificio{
    private final ITipoEdificio tipo;
    private IComportamientoEdificio comportamiento;
    private final Testigo testigo;

    public Edificio(ITipoEdificio tipo, IComportamientoEdificio comportamiento) {
        this.comportamiento = comportamiento;
        this.tipo = tipo;
        this.testigo = tipo.getTestigo();
    }

    public Edificio(ITipoEdificio tipo)
    {
        this(tipo, new SinComportamiento());
    }

    public String getNombre()
    {
        return tipo.getNombreTipo();
    }
    public boolean generarEvento(Ladron unLadron) {

        this.comportamiento = this.comportamiento.lanzarEvento( unLadron );
        return true;
    }

    public void visitadoPorLadron(ISospechoso ladron, Ciudad destino) {
        testigo.setTestimonio(ladron,destino);
    }

    public String visitar(Policia policia)
    {
        comportamiento.visitar((ITipoEdificio) this,policia);
        return testigo.getTestimonio(policia);
    }

    public boolean esElEdificio(String nombreDelEdificioAVisitar) {
        return (tipo.getNombreTipo().equals(nombreDelEdificioAVisitar));
    }
}