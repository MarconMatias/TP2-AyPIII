package edu.fiuba.algo3.modelo.Ciudad;

import edu.fiuba.algo3.modelo.Ciudad.EstadoVisitas.EstadoVisitasCiudad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstadoVisitasCiudadTest {
    @Test
    public void EstadoInicialDemora1()
    {
        EstadoVisitasCiudad estado = new EstadoVisitasCiudad();
        assertEquals(1,estado.demoraEdificio());
    }

    @Test
    public void EstadoAlVistiar1VezlDemora2()
    {
        EstadoVisitasCiudad estado = new EstadoVisitasCiudad();
        estado.siguiente();
        assertEquals(2,estado.demoraEdificio());
    }

    @Test
    public void EstadoAlVistiar2VeceslDemora3()
    {
        EstadoVisitasCiudad estado = new EstadoVisitasCiudad();
        estado.siguiente();
        estado.siguiente();
        assertEquals(3,estado.demoraEdificio());
    }

    @Test
    public void EstadoAlVistiar3VeceslDemora3()
    {
        EstadoVisitasCiudad estado = new EstadoVisitasCiudad();
        for(int i=0;i<3;i++)
        {
            estado.siguiente();
        }
        assertEquals(3,estado.demoraEdificio());
    }

    @Test
    public void EstadoAlVistiar17VeceslDemora3()
    {
        EstadoVisitasCiudad estado = new EstadoVisitasCiudad();
        for(int i=0;i<17;i++)
        {
            estado.siguiente();
        }
        assertEquals(3,estado.demoraEdificio());
    }
}
