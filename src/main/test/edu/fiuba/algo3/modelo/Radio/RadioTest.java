package edu.fiuba.algo3.modelo.Radio;

import edu.fiuba.algo3.modelo.Evento.RadioEvento;
import edu.fiuba.algo3.modelo.Evento.RadioListener;
import edu.fiuba.algo3.modelo.Evento.TrackCambia;
import edu.fiuba.algo3.modelo.Evento.VolumenCambia;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RadioTest {
    @Test
    public void radioCreadaEstaPrendida() {
        Radio radio = new Radio();
        assertTrue(radio.estaEncendida());
    }

    @Test
    public void radioCreadaAlPresionarBotonSeApaga() {
        Radio radio = new Radio();
        radio.pulsarBotonPrender();
        assertFalse(radio.estaEncendida());
    }

    @Test
    public void radioCreadaAlPresionarBoton2VecesSePrende() {
        Radio radio = new Radio();
        radio.pulsarBotonPrender();
        radio.pulsarBotonPrender();
        assertTrue(radio.estaEncendida());
    }

    @Test
    public void radioCreadaTieneTrack01() {
        Radio radio = new Radio();
        assertEquals(1, radio.getNumeroTrack());
    }

    @Test
    public void radioApagadaTieneTrack00() {
        Radio radio = new Radio();
        radio.pulsarBotonPrender();
        assertEquals(0, radio.getNumeroTrack());
    }

    @Test
    public void radioCreadaSiguienteTrackEs02() {
        Radio radio = new Radio();
        radio.pulsarBotonSiguiente();
        assertEquals(2, radio.getNumeroTrack());
    }

    @Test
    public void radioCreadaSiguienteAnteriorTrackEs01() {
        Radio radio = new Radio();
        radio.pulsarBotonSiguiente();
        radio.pulsarBotonAnterior();
        assertEquals(1, radio.getNumeroTrack());
    }

    @Test
    public void radioCreadaSiguiente2vecesTrackEs03() {
        Radio radio = new Radio();
        radio.pulsarBotonSiguiente();
        radio.pulsarBotonSiguiente();
        assertEquals(3, radio.getNumeroTrack());
    }

    @Test
    public void radioCreadaSiguiente3vecesTrackEs00() {
        Radio radio = new Radio();
        radio.pulsarBotonSiguiente();
        radio.pulsarBotonSiguiente();
        radio.pulsarBotonSiguiente();
        assertEquals(0, radio.getNumeroTrack());
    }

    @Test
    public void radioCreadaSiguiente4vecesTrackEs01() {
        Radio radio = new Radio();
        for(int i = 0; i<4; i++) {
            radio.pulsarBotonSiguiente();
        }
        assertEquals(1, radio.getNumeroTrack());
    }

    @Test
    public void radioCreadaSiguiente32vecesTrackEs01() {
        Radio radio = new Radio();
        for(int i = 0; i<32; i++) {
            radio.pulsarBotonSiguiente();
        }
        assertEquals(1, radio.getNumeroTrack());
    }


    @Test
    public void radioCreadaSiguiente33vecesTrackEs02() {
        Radio radio = new Radio();
        for(int i = 0; i<33; i++) {
            radio.pulsarBotonSiguiente();
        }
        assertEquals(2, radio.getNumeroTrack());
    }

    @Test
    public void radioCreadaSiguiente2vecesAnterior2vecesTrackEs01() {
        Radio radio = new Radio();
        for(int i = 0; i<2; i++) {
            radio.pulsarBotonSiguiente();
        }
        for(int i = 0; i<2; i++) {
            radio.pulsarBotonAnterior();
        }
        assertEquals(1, radio.getNumeroTrack());
    }

    @Test
    public void escuhandoTrackSiguienteDispara1vez() {
        RadioListener listener = mock(RadioListener.class);
        Radio radio = new Radio();
        radio.escucharTracks(listener);
        radio.pulsarBotonSiguiente();
        verify(listener, Mockito.times(1)).handle(any(RadioEvento.class));
    }

    @Test
    public void escuhandoTrackSiguienteAnteriorDispara2veces() {
        RadioListener listener = mock(RadioListener.class);
        Radio radio = new Radio();
        radio.escucharTracks(listener);
        radio.pulsarBotonSiguiente();
        radio.pulsarBotonAnterior();
        verify(listener, Mockito.times(2)).handle(any(RadioEvento.class));
    }

    @Test
    public void escuhandoTrackSiguiente3vecesDispara3veces() {
        RadioListener listener = mock(RadioListener.class);
        Radio radio = new Radio();
        radio.escucharTracks(listener);
        radio.pulsarBotonSiguiente();
        radio.pulsarBotonSiguiente();
        radio.pulsarBotonSiguiente();
        verify(listener, Mockito.times(3)).handle(any(RadioEvento.class));
    }

    @Test
    public void escuhandoTrackSiguiente3vecesTrackEs00() {
        AtomicInteger valor = new AtomicInteger(-1);
        Radio radio = new Radio();
        radio.escucharTracks(ev -> valor.set(((TrackCambia) ev).getNumeroTrack()));
        radio.pulsarBotonSiguiente();
        assertEquals(2, valor.get());
        radio.pulsarBotonSiguiente();
        assertEquals(3, valor.get());
        radio.pulsarBotonSiguiente();
        assertEquals(0, valor.get());
    }

    @Test
    public void creadoVolumen0_5() {
        Radio radio = new Radio();
        assertEquals(0.5, radio.getVolumen(), 1e-5);
    }

    @Test
    public void creadoYApagadoVolumen0() {
        Radio radio = new Radio();
        radio.pulsarBotonPrender();
        assertEquals(0.0, radio.getVolumen(), 1e-5);
    }

    @Test
    public void escuhandoVolumenSubir3vecesVolumenEs08() {
        AtomicReference<Double> valor = new AtomicReference<>((double) -1);
        Radio radio = new Radio();
        radio.escucharVolumen(ev -> valor.set(((VolumenCambia) ev).getVolumen()));
        radio.subirVolumen();
        assertEquals(0.6, valor.get(), 1e-5);
        radio.subirVolumen();
        assertEquals(0.7, valor.get(), 1e-5);
        radio.subirVolumen();
        assertEquals(0.8, valor.get(), 1e-5);
    }

}
