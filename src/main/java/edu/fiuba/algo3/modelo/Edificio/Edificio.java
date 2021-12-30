package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Ciudad.IDestino;
import edu.fiuba.algo3.modelo.Edificio.Testigo.Testigo;
import edu.fiuba.algo3.modelo.Edificio.TipoEdificio.ITipoEdificio;
import edu.fiuba.algo3.modelo.Ladron.ISospechoso;
import edu.fiuba.algo3.modelo.Ladron.Ladron;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.Random;

public class Edificio{
    private final ITipoEdificio tipo;
    private final Random random;
    private IAccionador accionador;
    private final Testigo testigo;

    public Edificio(ITipoEdificio tipo, IAccionador comportamiento, Random random) {
        this.accionador = comportamiento;
        this.tipo = tipo;
        this.testigo = tipo.getTestigo();
        this.random = random;
    }

    public Edificio(ITipoEdificio tipo, Random random)
    {
        this(tipo, new SinAccionador(), random);
    }

    public String getNombre()
    {
        return tipo.getNombreTipo();
    }
    public boolean generarEvento(Ladron unLadron) {

        this.accionador = this.accionador.lanzarEvento( unLadron );
        return true;
    }

    public boolean esElEdificio(String nombreDelEdificioAVisitar) {
        return (tipo.getNombreTipo().equals(nombreDelEdificioAVisitar));
    }

    public void setAccionador(IAccionador accionador) {
        this.accionador = accionador;
    }

    public void visitadoPorLadron(ISospechoso ladron, IDestino destino) {
        testigo.setTestimonio(ladron,destino);
    }

    public String visitar(Policia policia)
    {
        accionador.visitar(this,policia);
        return testigo.getTestimonio(policia);
    }

    public String getTestigo() {
        return testigo.getNombre();
    }
}