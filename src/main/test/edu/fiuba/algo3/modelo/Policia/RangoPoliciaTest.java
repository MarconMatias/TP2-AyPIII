package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Policia.RangoPolicia.RangoPolicia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangoPoliciaTest {
    @Test
    public void crearRangoPoliciaSinParámetrosEsNovato() {
        RangoPolicia rango = new RangoPolicia();
        assertEquals("Novato", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaConArrestosNegativosEsNovato() {
        RangoPolicia rango = new RangoPolicia(-1);
        assertEquals("Novato", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon0ArrestosEsNovato() {
        RangoPolicia rango = new RangoPolicia(0);
        assertEquals("Novato", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon4ArrestosEsNovato() {
        RangoPolicia rango = new RangoPolicia(4);
        assertEquals("Novato", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon5ArrestosEsDetective() {
        RangoPolicia rango = new RangoPolicia(5);
        assertEquals("Detective", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon9ArrestosEsDetective() {
        RangoPolicia rango = new RangoPolicia(9);
        assertEquals("Detective", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon10ArrestosEsInvestigador() {
        RangoPolicia rango = new RangoPolicia(10);
        assertEquals("Investigador", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon19ArrestosEsInvestigador() {
        RangoPolicia rango = new RangoPolicia(19);
        assertEquals("Investigador", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon20ArrestosEsSargento() {
        RangoPolicia rango = new RangoPolicia(20);
        assertEquals("Sargento", rango.getNombreRango());
    }

    @Test
    public void crearRangoPoliciaCon200ArrestosEsSargento() {
        RangoPolicia rango = new RangoPolicia(200);
        assertEquals("Sargento", rango.getNombreRango());
    }
}
